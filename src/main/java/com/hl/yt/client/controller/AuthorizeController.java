package com.hl.yt.client.controller;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.yt.client.dto.AuthorizeDTO;
import com.hl.yt.client.service.AuthorizeService;
import com.hl.yt.util.DateUtil;

@Controller
@RequestMapping("shouquanchaxun")
public class AuthorizeController {
	@Autowired
	AuthorizeService authorizeService;

	@RequestMapping("index")
	public String getDetail(Model model) {
		return "client/shouquanchaxun";
	}

	@RequestMapping("search/{parameter}")
	@ResponseBody
	public String search(@PathVariable("parameter") String parameter) {
		AuthorizeDTO authorize = authorizeService.getAuthorizes(parameter);
		if (authorize == null)
			return "";
		else
			return "s";
	}

	@RequestMapping("getImg/{parameter}")
	@ResponseBody
	public void getImg(@PathVariable("parameter") String parameter, HttpServletRequest request,
			HttpServletResponse response) {
		AuthorizeDTO authorize = authorizeService.getAuthorizes(parameter);
		String srcImageFile = request.getServletContext().getRealPath("/img/zs.jpg");
		pressText(response, authorize, srcImageFile);
	}

	private void pressText(HttpServletResponse response, AuthorizeDTO authorize, String srcImageFile) {
		try {
			File img = new File(srcImageFile);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Microsoft YaHei", Font.BOLD, 30));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1f));
			// 在指定坐标绘制水印文字
			g.drawString(authorize.getName(), 290, 565);
			switch (authorize.getProxyLevel()) {
			case 1:
				g.drawString("执行董事", 600, 715);
				break;
			case 2:
				g.drawString("总代", 600, 715);
				break;
			case 3:
				g.drawString("一级", 600, 715);
				break;
			case 4:
				g.drawString("二级", 600, 715);
				break;
			}
			g.drawString(authorize.getWechatNumber(), 410, 805);
			g.drawString(authorize.getPhoneNumber(), 410, 865);
			g.drawString(authorize.getCode(), 520, 923);
			g.drawString(DateUtil.dateToString(authorize.getStartDate()) + " 至 "
					+ DateUtil.dateToString(authorize.getEndDate()), 420, 1025);
			g.dispose();

			ImageIO.write((BufferedImage) image, "JPEG", response.getOutputStream());// 输出到文件流
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}