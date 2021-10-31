package com.spring.ex.dao;

import org.springframework.stereotype.Repository;

import com.spring.ex.vo.HeartVO;

@Repository
public interface HeartDAO {
	//게시글 좋아요 클릭 여부
	public int BoardLikeCheck(int checkLike) throws Exception;
	
	//게시글 좋아요 증가
	public int BoardLike(HeartVO vo) throws Exception;
	public int BoardLikeUp(int b_no) throws Exception;
	
	//게시글 좋아요 삭제 
	public int BoardLikeDelete(HeartVO vo) throws Exception;
	public int BoardLikeDown(int b_no) throws Exception;
}