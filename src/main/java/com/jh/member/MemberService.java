package com.jh.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.memberFile.MemberFileDAO;
import com.jh.memberFile.MemberFileDTO;
import com.jh.util.FileSaver;


@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private MemberFileDAO memberFileDAO;
	
	public int setWrite(MemberDTO memberDTO, MultipartFile multipartFile,HttpSession session)throws Exception{
		String id = memberDTO.getId();
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		
		String fname = fileSaver.saveFile(realPath, multipartFile);
		memberFileDTO.setId(id);
		memberFileDTO.setFname(fname);
		memberFileDTO.setOname(multipartFile.getOriginalFilename());
		int result = memberFileDAO.setWrite(memberFileDTO);
		
		return memberDAO.setWrite(memberDTO);
	}
	
	public MemberDTO getSelect(String id) throws Exception{
		return memberDAO.getSelect(id);
	}
	
	public void logout(HttpSession session) throws Exception{
		session.invalidate();
	}
}
