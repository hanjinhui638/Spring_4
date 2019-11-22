package com.jh.s4.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.model.BoardNoticeVO;
import com.jh.s4.model.BoardVO;
import com.jh.s4.model.FilesVO;
import com.jh.s4.service.BoardNoticeService;
import com.jh.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	@GetMapping(value = "fileDown")
	public ModelAndView fileDown(FilesVO FilesVO)throws Exception{
		FilesVO = boardNoticeService.fileSelect(FilesVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("file", FilesVO);
		mv.setViewName("fileDown");
		mv.addObject("board", "notice");
		return mv;
	}
	
	//fileDelete
	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(FilesVO noticeFilesVO)throws Exception{
		//System.out.println(noticeFilesVO.getFnum()); 
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.fileDelete(noticeFilesVO);
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	
	@RequestMapping("noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "Delete Success");
		}else {
			mv.addObject("msg", "Delete Fail");
		}
		mv.addObject("path", "notice/noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)	//file 파라미터와 같은 이름 
	public ModelAndView boardUpdate(BoardNoticeVO boardnoticeVO, MultipartFile[] file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
			
		int result = boardNoticeService.boardUpdate(boardnoticeVO, file, session);
		
		if(result>0) {
		
			
			mv.addObject("msg", "Update Success");
		}else {
			mv.addObject("msg", "Update Fail");
		}
		mv.addObject("path", "notice/noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeUpdate")
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		BoardNoticeVO noticeVO = (BoardNoticeVO)boardVO;
		int size = noticeVO.getFiles().size();
		mv.addObject("size", size);
		mv.addObject("update", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		BoardVO boardVO2 = boardNoticeService.boardSelect(boardVO);
		boardVO2.setContents(boardVO2.getContents().replace("\r\n", "<br>"));
		mv.addObject("board", "notice");
		mv.addObject("select", boardVO2);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
													//file-> 파라미터명과 동일하게 
		ModelAndView mv = new ModelAndView();	
		
		
		for(int i=0;i<file.length;i++) {
			System.out.println(file[i].getOriginalFilename());
			
			//ArrayList<MultipartFile>
			//System.out.println(file.get(i).getOriginalFilename());
		}
		
	int result = boardNoticeService.boardWrite(boardVO,file,session);
		if(result>0) { 
			mv.addObject("msg", "WriteSuccess");
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "WriteFail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeWrite")
	public ModelAndView boardWrite() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		
		return mv;
	}
}