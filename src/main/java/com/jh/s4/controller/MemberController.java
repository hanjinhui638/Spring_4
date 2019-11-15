package com.jh.s4.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s4.model.MemberVO;
import com.jh.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Inject
	private MemberServiceImpl memberServiceImpl;
	
	@GetMapping(value = "memberJoin")
	public void memberJoin()throws Exception{
		
	}
	
	@PostMapping(value = "memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberJoin(memberVO);
			if (result>0) {
				mv.addObject("msg", "Join");
			}else {
				mv.addObject("msg", "Fail");
				
			}
			mv.addObject("path", "../");
			mv.setViewName("common/common_result");
		
		
		return mv;
	}
	
	
}
