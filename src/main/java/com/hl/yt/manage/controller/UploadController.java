package com.hl.yt.manage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hl.yt.common.R;
import com.hl.yt.manage.dto.FileDTO;
import com.hl.yt.manage.service.FileService;

@Controller
public class UploadController {

	@Autowired
	FileService fileService;

	@RequestMapping("manage/upload")
	@ResponseBody

	public R uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		String originalName = file.getOriginalFilename();

		String fileName = System.currentTimeMillis() + originalName.substring(originalName.lastIndexOf("."));

		// TODO 修改上传至oss

		String path = request.getSession().getServletContext().getRealPath("/");

		File dir = new File(path + "upload");

		if (!dir.exists())

			dir.mkdirs();

		String filePath = request.getSession().getServletContext().getRealPath("upload/") + "/" + fileName;

		try {

			file.transferTo(new File(filePath));

		} catch (IllegalStateException e) {

			e.printStackTrace();

			return null;

		} catch (IOException e) {

			e.printStackTrace();

			return null;

		}

		return saveFile(originalName, "upload/" + fileName);

	}

	public R saveFile(String name, String fileName) {
		FileDTO file = new FileDTO();
		file.setPath(fileName);
		file.setName(name);
		fileService.saveFile(file);
		return R.ok().put("file", file);
	}

}
