package com.hl.yt.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.manage.dto.FileDTO;

public interface FileDao {
	void saveFile(FileDTO file);

	FileDTO getPath(int id);

	List<String> getAlbum(@Param("ids") String ids[]);
}
