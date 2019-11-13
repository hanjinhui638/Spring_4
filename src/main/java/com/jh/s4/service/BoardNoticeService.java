package com.jh.s4.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;


import com.jh.s4.dao.BoardNoticeDAO;
import com.jh.s4.model.BoardVO;
import com.jh.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {
	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		/* null 주의 */
		return boardNoticeDAO.boardList(pager); 
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
