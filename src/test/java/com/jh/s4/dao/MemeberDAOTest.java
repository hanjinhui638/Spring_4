package com.jh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s4.TestAbstractCase;
import com.jh.s4.model.MemberVO;

public class MemeberDAOTest extends TestAbstractCase{
	
	@Inject
	private MemberDAO memberDAO;
	
	//@Test
	public void memberJoinTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id3");
		memberVO.setPw("pw3");
		memberVO.setName("name3");
		memberVO.setEmail("c@g.com");
		memberVO.setBirth("2000-10-10");
		memberVO.setGender("F");
		int result = memberDAO.memberJoin(memberVO);
		assertEquals(1, result);
		
	}
	
	//@Test
	public void memberUpdateTest()throws Exception{
		MemberVO memberVO =new MemberVO();
		
		memberVO.setId("id3");
		memberVO.setPw("test3");
		memberVO.setName("name3");
		memberVO.setEmail("k@g.com");
		memberVO.setBirth("2000-12-12");
			
		int result = memberDAO.memberUpdate(memberVO);
		assertEquals(1, result);
	}
	
	@Test
	public void memberDeleteTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("id3");
		int result = memberDAO.memberDelete(memberVO);
		
		assertEquals(1, result);
		
	}
}
