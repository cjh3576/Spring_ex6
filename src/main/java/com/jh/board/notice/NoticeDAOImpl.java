package com.jh.board.notice;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.board.BoardDAO;
import com.jh.board.BoardDTO;
import com.jh.util.PageMaker;

@Repository
public class NoticeDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "NoticeMapper.";
	
	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardDTO", boardDTO);
		map.put("pnum", 0);
		
		int result = sqlSession.insert(NAMESPACE+"noticeWrite", boardDTO);
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"noticeList",pageMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"noticeSelect", num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		int result = sqlSession.delete(NAMESPACE+"noticeDelete", num);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"noticeUpdate", boardDTO);
	}

	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"totalCount",pageMaker);
	}
	

}
