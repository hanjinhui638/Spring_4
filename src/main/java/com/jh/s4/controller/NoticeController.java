package com.jh.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.model.BoardVO;
import com.jh.s4.service.BoardNoticeService;
import com.jh.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	
	//Select
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		
			if(boardVO == null) {
				mv.addObject("msg", "fail");
				mv.addObject("path", "noticeList");
				mv.setViewName("common/common_result");
			}else {
				mv.addObject("noticeVO", boardVO);
				mv.addObject("board", "notice");
				mv.setViewName("notice/noticeSelect");
			}
			return mv;
	}
	
	
	//write
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite"); 
		return mv;
	}
	
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardWrite(boardVO);
		
		if(result > 0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "Fail");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}	
			
		return mv;
	}
	
	//List
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager)throws Exception{
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}
}
