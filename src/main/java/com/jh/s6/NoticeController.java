package com.jh.s6;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.board.BoardDTO;
import com.jh.board.notice.NoticeDTO;
import com.jh.board.notice.NoticeServiceImpl;
import com.jh.util.FileSaver;
import com.jh.util.PageMaker;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	@Autowired
	private NoticeServiceImpl noticeService;
	//list
	@RequestMapping(value ="noticeList", method = RequestMethod.GET)
	public ModelAndView getList(PageMaker pageMaker,ModelAndView mv) throws Exception{
		List<BoardDTO> ar = noticeService.getList(pageMaker);
		mv.addObject("list", ar);
		mv.addObject("pager", pageMaker);
		mv.addObject("board", "notice");
		
		mv.setViewName("board/boardList");
		return mv;
		
	}
	//write form
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String noticeWrite(Model model) throws Exception{
		model.addAttribute("board","notice");
		return "board/boardWrite";
	}
	//write insert
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO,Model model, List<MultipartFile> f1, HttpSession session) throws Exception{
		String path = session.getServletContext().getRealPath("/resources/upload");
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		FileSaver fs = new FileSaver();
		String fname = fs.saveFile2(path, f1.get(0));
		
		//System.out.println(fname);
		for(MultipartFile f : f1) {
			String name = f.getOriginalFilename();
		}
		
		int result = noticeService.setWrite(noticeDTO, f1, session);
		String view = "common/messageMove";
		if(result>0) {
			view ="redirect:./noticeList";
		}else {
			model.addAttribute("message", "Write Fail");
			model.addAttribute("path","./noticeList");
		}
		return view;
	}
	//select
	@RequestMapping (value = "noticeSelect", method = RequestMethod.GET)
	public String getSelect(Model model, @RequestParam(defaultValue = "0", required = false) int num) throws Exception{
		BoardDTO boardDTO= noticeService.getSelect(num);
		String view = "common/messageMove";
		
		if(boardDTO!= null) {
			view= "board/boardSelect";
		 	model.addAttribute("dto", boardDTO);
		 	model.addAttribute("board","notice");
		}else {
			model.addAttribute("message", "Not Found");
			model.addAttribute("path","./noticeList");
		}
		return view;
	}
	//delete
	@RequestMapping (value ="noticeDelete", method = RequestMethod.GET)
	public String getDelete(int num,Model model) throws Exception{
		int result = noticeService.setDelete(num);
		String view = "common/messageMove";
		if(result >0) {
			model.addAttribute("message","Delete Success");
			model.addAttribute("path", "./noticeList");
		}else {
			model.addAttribute("message","Delete Fail");
			model.addAttribute("path","./noticeList");
		}
		return view;
	}
	//update form
	@RequestMapping (value="noticeUpdate",method = RequestMethod.GET)
	public ModelAndView noticeUpdate(ModelAndView mv,int num) throws Exception{
		mv.addObject("board","notice");
		BoardDTO noticeDTO= noticeService.getSelect(num);
		if(noticeDTO!=null) {
		mv.addObject("dto", noticeDTO);
		mv.setViewName("board/boardUpdate");
		}else {
			mv.addObject("message", "Update Fail");
			mv.setViewName("board/boardUpdate");
		}
		return mv;
	}
	
	//Update insert
		@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
		public String noticeUpdate(NoticeDTO noticeDTO,Model model) throws Exception{
			int result = noticeService.setUpdate(noticeDTO);
			String view = "common/messageMove";
			if(result>0) {
				model.addAttribute("message", "Update Success");
				model.addAttribute("path","./noticeList");
			}else {
				model.addAttribute("message", "Update Fail");
				model.addAttribute("path","./noticeList");
			}
			return view;
		}
}
