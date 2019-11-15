package com.jh.s4.dao;

import com.jh.s4.model.MemberVO;

public interface MemberDAO {

		//join 메소드 이름 mapper의 아이디와 동일하게 
		public int memberJoin(MemberVO memberVO)throws Exception;
	
		//login 
		public MemberVO memberLogin(MemberVO memberVO)throws Exception;
			
		//update
		public int memberUpdate(MemberVO memberVO)throws Exception;
		
		//delete
		public int memberDelete(MemberVO memberVO)throws Exception;
		
		//point update
		public int memberPointUpdate(MemberVO memberVO)throws Exception;

}
