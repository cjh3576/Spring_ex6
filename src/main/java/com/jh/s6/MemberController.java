package com.jh.s6;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jh.member.MemberDTO;
import com.jh.member.MemberService;
import com.jh.util.FileSaver;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Inject
	private MemberService memberService;
	
	//join form
	@RequestMapping(value="memberJoin", method = RequestMethod.GET)
	public String setWrite(Model model)throws Exception{
		return "member/memberJoin";
	}
	//join insert 회원가입
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String setWrite(MemberDTO memberDTO,Model model,MultipartFile f1,HttpSession session )throws Exception{
		int result = memberService.setWrite(memberDTO, f1, session);
		String view = "common/messageMove";
		if(result>0) {
			view = "redirect:../";
		}else {
			model.addAttribute("message","Join Fail");
			model.addAttribute("path", "./memberJoin");
		}
		return view;
	}
	
	//login form
	@RequestMapping(value="memberLogin", method = RequestMethod.GET)
	public String getSelect(Model model)throws Exception{
		return "member/memberLogin";
	}
	
	//login 
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String getLogin(String id,HttpSession session,Model model) throws Exception{
		MemberDTO memberDTO= memberService.getSelect(id);
		String view = "common/messageMove";
		if(memberDTO != null) {
			session.setAttribute("dto", memberDTO);
			model.addAttribute("message", "Login Success");
			model.addAttribute("path", "../");
		}else {
			model.addAttribute("message","Login Fail");
			model.addAttribute("path", "./memberLogin");
		}
		return view;
	}
	
	//logout
	@RequestMapping(value="memberLogout")
	public String getLogout(HttpSession session) throws Exception{
		memberService.logout(session);
		return "redirect:../";
	}
	
}
