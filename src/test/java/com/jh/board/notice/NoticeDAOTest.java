package com.jh.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.support.DaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jh.board.BoardDTO;
import com.jh.s6.AbstractTest;
import com.jh.util.PageMaker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class NoticeDAOTest extends AbstractTest{
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
//	@Test
//	public void test() throws Exception{
//		BoardDTO boardDTO = noticeDAOImpl.getSelect(10);
//		assertNotNull(boardDTO);
//	}
//	
//	@Test
//	public void test2() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("hihi");
//		boardDTO.setWriter("jh");
//		boardDTO.setContents("kkk");
//		
//		int result = noticeDAOImpl.setWrite(boardDTO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void test3() throws Exception{
//		int result = noticeDAOImpl.setDelete(30);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void update() throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNum(26);
//		noticeDTO.setTitle("change");
//		noticeDTO.setContents("change");
//		int result = noticeDAOImpl.setUpdate(noticeDTO);
//		assertEquals(1, result);
//	}
//	@Test
//	public void selectOne() throws Exception{
//		BoardDTO boardDTO = noticeDAOImpl.getSelect(26);
//		assertNotNull(boardDTO);
//	}
/*	@Test
	public void selectList() throws Exception{
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCurPage(1);
		pageMaker.setKind("");
		pageMaker.setSearch("");
		pageMaker.makeRow();
		int totalCount = noticeDAOImpl.getTotalCount(pageMaker);
		//페이지 처리 계산
		pageMaker.makePage(totalCount);
		List<BoardDTO> ar = noticeDAOImpl.getList(pageMaker);
		assertNotEquals(0, ar.size());
	}*/
//	@Test
//	public void test4() throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("kk");
//		boardDTO.setWriter("JHJH");
//		boardDTO.setContents("zzzzzzzzzzzzzzzzzzzzzzzzz");
//		boardDTO.setNum(8);
//		int result = noticeDAOImpl.setUpdate(boardDTO);
//		assertEquals(1, result);
//	}
//	@Test
//	public void getCount() throws Exception{
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setKind("1");
//		pageMaker.setSearch("change");
//		int result = noticeDAOImpl.getTotalCount(pageMaker);
//		assertEquals(1, result);
//	}
	@Test
	public void getNum() throws Exception{
		int num = noticeDAOImpl.getNum();
		assertNotEquals(0,num);
	}
	

}
