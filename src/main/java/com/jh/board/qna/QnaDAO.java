package com.jh.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.board.BoardDAO;
import com.jh.board.BoardDTO;
import com.jh.util.DBConnector;
import com.jh.util.PageMaker;

@Repository
public class QnaDAO implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	private String mapper ="QnaMapper.";
	

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(mapper+"qnaWrite", boardDTO);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		return sqlSession.selectList(mapper+"qnaList");
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return sqlSession.selectOne(mapper+"qnaSelect", num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return sqlSession.delete(mapper+"qnaDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(mapper+"qnaUpdate", boardDTO);
	}

	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
