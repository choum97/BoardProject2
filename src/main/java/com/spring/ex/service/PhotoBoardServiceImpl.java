package com.spring.ex.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.ex.dao.PhotoBoardDAO;
import com.spring.ex.vo.PhotoBoardVO;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {
	@Inject
	private PhotoBoardDAO dao;
	
	//게시글 작성
	public int PhotoBoardWrite(PhotoBoardVO vo) throws Exception {
		return dao.PhotoBoardWrite(vo);
	}
	
	//게시글 수정 
	public int PhotoBoardModify(PhotoBoardVO vo) throws Exception {
		return dao.PhotoBoardModify(vo);
	}
		
	//게시글 삭제
	public int PhotoBoardDelete(int b_no) throws Exception {
		return dao.PhotoBoardDelete(b_no);
	}
	
	//게시글 출력
	public List<PhotoBoardVO> PhotoBoardList(HashMap<String, Integer> map) throws Exception {
		return dao.PhotoBoardList(map);
	}
	
	//게시글 조회
	public PhotoBoardVO PhotoBoardView(int b_no) throws Exception {
		return dao.PhotoBoardView(b_no);
	}
	
	//게시글 조회수 증가
	public void PhotoBoardHit(int b_no) throws Exception {
		dao.PhotoBoardHit(b_no);
	}
	
	//게시글 총 갯수 - 페이징
	public int PhotoBoardTotalCount() throws Exception {
		return dao.PhotoBoardTotalCount();
	}
}