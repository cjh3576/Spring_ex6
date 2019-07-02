package com.jh.board.file;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.jh.file.FileDAO;
import com.jh.file.FileDTO;
import com.jh.s6.AbstractTest;

public class FileDAOTest extends AbstractTest{
	@Inject
	private FileDAO fileDAO;
	private FileDTO fileDTO;
	
	@Before
	public void ready() {
		fileDTO = new FileDTO();
		fileDTO.setNum(1);
		fileDTO.setFname("fname");
		fileDTO.setOname("oname");
	}
	@Test
	public void setWrite() throws Exception{
		int result = fileDAO.setWrite(fileDTO);
		assertEquals(1, result);
	}
	
}
