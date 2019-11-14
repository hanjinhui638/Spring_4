package com.jh.s4.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s4.TestAbstractCase;
import com.jh.s4.model.BoardVO;

public class BoardQnADAOTest extends TestAbstractCase{
	
	@Inject
	private BoardQnaDAO boardQnaDAO;
	
		//@Test
		public void boardWriteTest() throws Exception{
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("test title");
			boardVO.setContents("test contents");
			boardVO.setWriter("test writer");
			int result = boardQnaDAO.boardWrite(boardVO);
			assertEquals(1, result);
		}
		
		
		//@Test
		public void boardSelectTest() throws Exception {
			BoardVO boardVO = new BoardVO();
			boardVO.setNum(1);
			boardVO = boardQnaDAO.boardSelect(boardVO);
			
			assertNotNull(boardVO);
		}
		
		
		
		
		@Test
		public void noticeUpdate()throws Exception{
			BoardVO boardVO = new BoardVO();
			
			boardVO.setTitle("a1");
			boardVO.setContents("aa");
			boardVO.setNum(4);
			
			int result = boardQnaDAO.boardUpdate(boardVO);
			assertEquals(1, result);
			
		}
		

		//@Test
		public void boardDeleteTest() throws Exception {
			BoardVO boardVO = new BoardVO();
			boardVO.setNum(1);	
			int result = boardQnaDAO.boardDelete(boardVO);
			
			assertEquals(1, result);
		}
		
}
