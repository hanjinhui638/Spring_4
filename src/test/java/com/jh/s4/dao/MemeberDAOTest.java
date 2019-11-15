package com.jh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s4.TestAbstractCase;
import com.jh.s4.model.MemberVO;

public class MemeberDAOTest extends TestAbstractCase{
	
	@Inject
	private MemberDAO memberDAO;
	
	@Test
	public void memberJoinTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("id1");
		memberVO.setPw("pw1");
		memberVO.setName("name1");
		memberVO.setEmail("a@g.com");
		memberVO.setBirth("2000-11-15");
		memberVO.setGender("M");
		int result = memberDAO.memberJoin(memberVO);
		assertEquals(1, result);
		
	}
	
}
