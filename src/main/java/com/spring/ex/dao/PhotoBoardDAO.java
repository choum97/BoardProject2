package com.spring.ex.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ex.vo.PhotoBoardVO;

@Repository
public interface PhotoBoardDAO {
	
	//게시글 작성
	public int PhotoBoardWrite(PhotoBoardVO vo) throws Exception;
	
	//게시글 수정 
	public int PhotoBoardModify(PhotoBoardVO vo) throws Exception;
		
	//게시글 삭제
	public int PhotoBoardDelete(int b_no) throws Exception;
	
	//게시글 이미지 파일이름 검색 - 파일 삭제하려고 사용
	public String PhotoBoardFileName(int b_no) throws Exception;
	
	//게시글 출력
	public List<PhotoBoardVO> PhotoBoardList(HashMap<String, Integer> map) throws Exception;
	
	//게시글 조회
	public PhotoBoardVO PhotoBoardDetailView(int b_no) throws Exception;
	
	//게시글 조회수 증가
	public void PhotoBoardHit(int b_no) throws Exception;
	
	//게시글 총 갯수 - 페이징
	public int PhotoBoardTotalCount() throws Exception;
	
}