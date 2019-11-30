package com.jh.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.model.BoardVO;
import com.jh.s4.service.BoardNoticeService;
import com.jh.s4.util.Pager;

@RestController
public class JsonController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	
	@GetMapping("/getJson3")
	public List<BoardVO> getJson3(Pager pager)throws Exception{
		
		return boardNoticeService.boardList(pager);
		
		//String message="[{},{},{}]";
		
	}
	
	
	//@ResponseBody	response에 담아서  view를 걸치지 않고 요청한 곳으로 return 
	@GetMapping("/getJson2")			
	public BoardVO getJson2(BoardVO boardVO)throws Exception{
		//ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		//String message = "{\"writer\":\""+boardVO.getWriter()+"\", \"title\":\""+boardVO.getTitle()+"\", \"contents\":\""+boardVO.getContents()+"\"}";
		
		//mv.addObject("result", message);
		//mv.setViewName("common/common_ajaxResult");
		
		return boardVO;	
	}
		
		@GetMapping("/getJson1")
		public ModelAndView getJson1()throws Exception{
			//name = iu, age= 27
			String jmessage = "{\"name\":\"iu\", \"age\":27}";
			System.out.println(jmessage);
			ModelAndView mv = new ModelAndView();
			mv.addObject("result", jmessage);
			mv.setViewName("common/common_ajaxResult");
			return mv; 
		}
}
