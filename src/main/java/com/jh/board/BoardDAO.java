package com.jh.board;

import java.util.List;

import com.jh.util.PageMaker;

public interface BoardDAO {
	//글 추가
	public int setWrite(BoardDTO boardDTO) throws Exception;
	
	//리스트
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception;
	
	//글 하나
	public BoardDTO getSelect(int num)throws Exception;
	//삭제
	public int setDelete(int num) throws Exception;
	
	//업뎃
	public int setUpdate (BoardDTO boardDTO) throws Exception;
	
	public int getTotalCount(PageMaker pageMaker) throws Exception;
	
}
