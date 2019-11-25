package com.jh.s4.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.s4.dao.BoardNoticeDAO;
import com.jh.s4.dao.NoticeFilesDAO;
import com.jh.s4.model.BoardNoticeVO;
import com.jh.s4.model.BoardVO;
import com.jh.s4.model.FilesVO;
import com.jh.s4.util.FileSaver;
import com.jh.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	//@Inject
	//private HttpSession session;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	
	public boolean summerfileDelete(String file, HttpSession session)throws Exception{
		
		String realPath = session.getServletContext().getRealPath("resources/upload/summerfile");
		return fileSaver.fileDelete(realPath, file);
	}
	
	
	public String summerfile(MultipartFile file, HttpSession session)throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload/summerfile");
		return fileSaver.save(realPath, file);
	}
	
	public FilesVO fileSelect(FilesVO noticeFilesVO)throws Exception{
		return noticeFilesDAO.fileSelect(noticeFilesVO);
	}
	
	
	public int fileDelete(FilesVO noticeFilesVO)throws Exception{
		return noticeFilesDAO.fileDelete(noticeFilesVO);
	}
	
	/**/
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		//boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
	
		//List<NoticeFilesVO> ar = noticeFilesDAO.fileList(boardVO.getNum());
		
		//boardNoticeVO.setFiles(ar);
		
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session)throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		FilesVO noticeFilesVO = new FilesVO();
		int result = boardNoticeDAO.boardWrite(boardVO);
		noticeFilesVO.setNum(boardVO.getNum());
		
		
		 for(MultipartFile multipartFile:file) {			
		  if(multipartFile.getSize() != 0){							//multipartFile.getOriginalFilename() !== " "
		 String fileName = fileSaver.save(realPath, multipartFile);
		 noticeFilesVO.setFname(fileName);
		 noticeFilesVO.setOname(multipartFile.getOriginalFilename());
		 result =  noticeFilesDAO.fileWrite(noticeFilesVO);
		 	if(result<1) {
		 		throw new SQLException();
		 	}
		 
		  }
		 }
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		FilesVO noticeFilesVO = new FilesVO();
		int result = boardNoticeDAO.boardUpdate(boardVO);
		
		noticeFilesVO.setNum(boardVO.getNum());
		
		for(MultipartFile multipartFile:file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(multipartFile.getOriginalFilename());
			result = noticeFilesDAO.fileWrite(noticeFilesVO);
		}
		
		return result;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
