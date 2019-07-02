package com.jh.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jh.board.BoardDTO;
import com.jh.s6.AbstractTest;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class QnaDAOTest extends AbstractTest{
	@Inject
	private QnaDAO qnaDAO;
	@Test
	public void insert() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title");
		qnaDTO.setWriter("writer");
		qnaDTO.setContents("contents");
		int result = qnaDAO.setWrite(qnaDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void update() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("change");
		qnaDTO.setContents("change");
		qnaDTO.setNum(34);
		int result = qnaDAO.setUpdate(qnaDTO);
		
		assertEquals(1, result);
	}
	
//	@Test
//	public void delete() throws Exception{
//		int result = qnaDAO.setDelete(33);
//		assertEquals(1, result);
//	}
	
	@Test
	public void select() throws Exception{
		BoardDTO boardDTO= qnaDAO.getSelect(34);
		assertNotNull(boardDTO);
	}
	
	@Test
	public void selectList() throws Exception{
	}

}
