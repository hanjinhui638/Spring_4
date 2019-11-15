package com.jh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s4.TestAbstractCase;
import com.jh.s4.model.BoardNoticeVO;
import com.jh.s4.model.BoardVO;

public class BoardNoticeDAOTest extends TestAbstractCase{

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Test
	public void boardWriteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test title");
		boardVO.setContents("test contents");
		boardVO.setWriter("test writer");
		int result = boardNoticeDAO.boardWrite(boardVO);
		assertEquals(1, result);
	}
	
	
	@Test
	public void boardSelectTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(2);
		boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		assertNull(boardVO);
	}
	
	
	
	
	@Test
	public void noticeUpdate()throws Exception{
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("a1");
		boardVO.setContents("aa");
		boardVO.setNum(2);
		
		int result = boardNoticeDAO.boardUpdate(boardVO);
		assertEquals(1, result);
		
	}
	

	@Test
	public void boardDeleteTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3);	
		int result = boardNoticeDAO.boardDelete(boardVO);
		
		assertEquals(1, result);
	}
	

}
