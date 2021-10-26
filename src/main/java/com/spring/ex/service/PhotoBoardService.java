package com.spring.ex.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.ex.vo.PhotoBoardVO;

@Service
public interface PhotoBoardService {
	//게시글 작성
	public int PhotoBoardWrite(PhotoBoardVO vo) throws Exception;
	
	//게시글 수정 
	public int PhotoBoardModify(PhotoBoardVO vo) throws Exception;
		
	//게시글 삭제
	public int PhotoBoardDelete(int b_no) throws Exception;
	
	//게시글 출력
	public List<PhotoBoardVO> PhotoBoardList(HashMap<String, Integer> map) throws Exception;
	
	//게시글 조회
	public PhotoBoardVO PhotoBoardView(int b_no) throws Exception;
	
	//게시글 조회수 증가
	public void PhotoBoardHit(int b_no) throws Exception;
	
	//게시글 총 갯수 - 페이징
	public int PhotoBoardTotalCount() throws Exception;
}