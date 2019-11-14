package com.jh.s4.controller;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.model.BoardQnaVO;
import com.jh.s4.model.BoardVO;
import com.jh.s4.service.BoardQnaService;
import com.jh.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	
	@Inject
	private BoardQnaService boardQnaService;
	
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView qnaWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
		
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardWrite(boardVO);
		
		if(result > 0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("msg", "Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}	
		
		return mv;
	}
	
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView(); /* 보내줄 경로가 qna가 아니기 때문에 */
		List<BoardVO> ar =  boardQnaService.boardList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");

		/*
		 * BoardVO boardVO = new BoardQnaVO(); 
		 * BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO; 
		 * boardQnaVO.getRef();
		 */
		
		return mv;
	}
}
