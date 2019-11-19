package com.jh.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jh.s4.dao.BoardQnaDAO;
import com.jh.s4.model.BoardQnaVO;
import com.jh.s4.model.BoardVO;
import com.jh.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {

	@Inject
	private BoardQnaDAO boardQnaDAO;
	
	public int boardReply(BoardVO boardVO) throws Exception {
		boardQnaDAO.boardReplyUpdate(boardVO);
		
		return boardQnaDAO.boardReply(boardVO);
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardDelete(boardVO);
	}

}
