package com.jh.member;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.memberFile.MemberFileDAO;

public class MemberDAOTest {
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private MemberFileDAO memberFileDAO;
	
	@Test
	public void logintest() throws Exception{
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setId("jh");
	memberDTO.setPw("jh");
	memberDTO = memberDAO.getSelect(memberDTO);
	System.out.println(memberDTO.getEmail());
	System.out.println(memberDTO.getMemberFileDTO().getFname());
	}

}
