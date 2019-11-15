package com.jh.s4.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping(value = "memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
			//session.removeAttribute("member");
			session.invalidate(); //유지시간을 0으로 변경 
			return "redirect:../";
	}
	
	//Login
	
	@GetMapping(value = "memberLogin")
	public void memberLogin()throws Exception{
			
	}
	
	@PostMapping(value = "memberLogin")
	public String memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		memberVO = memberServiceImpl.memberLogin(memberVO);
			
		if(memberVO !=null){
			session.setAttribute("member", memberVO);
		}
		
		return "redirect:../";
	}
	
	
	//checkId
	@GetMapping(value = "memberCheckId")
	public void memberCheckId(MemberVO memberVO, Model model)throws Exception{
		memberVO = memberServiceImpl.memberCheckId(memberVO);
		/* checkVO null: 사용가능 */
		
		String result = "중복된 ID";
		if(memberVO == null){
			//사용가능
			result = "사용가능한 ID";
		}//중복
		
		model.addAttribute("dto", memberVO);
		model.addAttribute("result", result);
	
		
	}
	
	
	//Join	
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
