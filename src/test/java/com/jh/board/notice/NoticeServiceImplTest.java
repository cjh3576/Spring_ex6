package com.jh.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.board.BoardDTO;
import com.jh.s6.AbstractTest;
import com.jh.util.PageMaker;

public class NoticeServiceImplTest extends AbstractTest{
	@Inject
	private NoticeServiceImpl noticeServiceImpl;
	@Test
	public void test() throws Exception{
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCurPage(1);
		pageMaker.setKind("");
		List<BoardDTO> ar = noticeServiceImpl.getList(pageMaker);
		
		assertEquals(10, ar.size());
	}

}
