package com.spring.ex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.ex.dao.HeartDAO;
import com.spring.ex.vo.HeartVO;

@Service
public class HeartServiceImpl implements HeartService {
	@Inject
	private HeartDAO dao;
	
	//게시글 좋아요 클릭 여부
	@Override
	public int BoardLikeCheck(String m_userId) throws Exception {
		return dao.BoardLikeCheck(m_userId);
	}

	//게시글 좋아요 증가 
	//생성
	@Override
	public int BoardLike(HeartVO vo) throws Exception {
		return dao.BoardLike(vo);
	}
	//값 수정
	@Override
	public int BoardLikeUp(int b_no) throws Exception {
		return dao.BoardLikeUp(b_no);
	}

	//게시글 좋아요 삭제 
	//삭제
	@Override
	public int BoardLikeDelete(HeartVO vo) throws Exception {
		return dao.BoardLikeDelete(vo);
	}
	//값 수정
	@Override
	public int BoardLikeDown(int b_no) throws Exception {
		return dao.BoardLikeDown(b_no);
	}

}
