package com.jh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s4.TestAbstractCase;
import com.jh.s4.model.BoardVO;

public class BoardNoticeDAOTest extends TestAbstractCase{

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	//@Test
	public void boardWriteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test title");
		boardVO.setContents("test contents");
		boardVO.setWriter("test writer");
		int result = boardNoticeDAO.boardWrite(boardVO);
		assertEquals(1, result);
	}
	
	@Test
	public void boardSelectTest()throws Exception{
		BoardVO boardVO = new BoardVO();
		int result =  boardNoticeDAO.boardSelect(boardVO);
		
	}
	

}
