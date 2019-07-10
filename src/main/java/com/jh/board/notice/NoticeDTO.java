package com.jh.board.notice;

import java.util.List;

import com.jh.board.BoardDTO;
import com.jh.file.FileDTO;

public class NoticeDTO extends BoardDTO{
	private List<FileDTO> files;

	public List<FileDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}
	
}
