package com.jh.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.s4.model.BoardQnaVO;
import com.jh.s4.model.BoardVO;
import com.jh.s4.util.Pager;

@Repository
public class BoardQnaDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final static String NAMESPACE = "qnaMapper.";
	
	public int boardReplyUpdate(BoardQnaVO boardQnAVO)throws Exception{
			return sqlSession.update(NAMESPACE+"boardReplyUpdate", boardQnAVO);
	}
	
	public int boardReply(BoardQnaVO boardQnaVO)throws Exception{
			return sqlSession.insert(NAMESPACE+"boardReply", boardQnaVO);
		
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"boardList", pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"boardSelect", boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"boardDelete", boardVO);
	}

	@Override
	public int boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount", pager);
	}

}
