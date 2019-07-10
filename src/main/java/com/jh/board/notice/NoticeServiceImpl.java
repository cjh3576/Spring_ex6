package com.jh.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.jh.board.BoardDTO;
import com.jh.board.BoardService;
import com.jh.file.FileDAO;
import com.jh.file.FileDTO;
import com.jh.util.FileSaver;
import com.jh.util.PageMaker;


@Service
public class NoticeServiceImpl implements BoardService {
	@Autowired
	private NoticeDAOImpl noticeDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		int result = noticeDAO.setWrite(boardDTO);
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		System.out.println(realPath);
		for(MultipartFile multipartFile: multipartFiles) {
			String fname = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			files.add(fileDTO);
		}
		fileDAO.setWrite(files);
		//파일을 hdd에 저장
		//notice 테이블에 저장
		//num 받아옴
		
		//files 테이블에 저장
		
		
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.makeRow();
		int totalCount = noticeDAO.getTotalCount(pageMaker);
		//페이지 처리 계산
		pageMaker.makePage(totalCount);
		//
		
		return noticeDAO.getList(pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return noticeDAO.getSelect(num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return noticeDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}
	
	
}
