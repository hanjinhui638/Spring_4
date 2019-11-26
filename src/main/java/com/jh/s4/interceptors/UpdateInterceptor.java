package com.jh.s4.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jh.s4.model.BoardVO;
import com.jh.s4.model.MemberVO;

@Component
public class UpdateInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//id
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		//writer
		Map<String, Object> map = modelAndView.getModel();
		BoardVO boardVO = (BoardVO)map.get("update");
		String board = (String)map.get("board");
		
		if(!memberVO.getId().equals(boardVO.getWriter())) {
			
			modelAndView.addObject("msg", "권한이 없음");
			modelAndView.addObject("path", board+"List");			//현재위치 qna or notice
			modelAndView.setViewName("common/common_result");	
			
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
