package com.jh.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.s4.model.NoticeFilesVO;

@Repository
public class NoticeFilesDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeFilesMapper.";
	
	public NoticeFilesVO fileSelect(NoticeFilesVO noticeFilesVO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect", noticeFilesVO);
	}
	
	public int fileWrite(NoticeFilesVO noticeFilesVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"fileWrite", noticeFilesVO);
		
	}
	
	public List<NoticeFilesVO> fileList(int num)throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList", num);
		
	}
	
	public int fileDelete(NoticeFilesVO noticeFilesVO)throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", noticeFilesVO);
		
	}
}
