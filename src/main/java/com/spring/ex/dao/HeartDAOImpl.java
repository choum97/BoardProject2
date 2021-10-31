package com.spring.ex.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ex.vo.HeartVO;

@Repository
public class HeartDAOImpl implements HeartDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.spring.ex.HeartMapper";
	
	//게시글 좋아요 클릭 여부
	@Override
	public int BoardLikeCheck(int checkLike) throws Exception {
		return sqlSession.selectOne(namespace + ".BoardLikeCheck", checkLike);
	}

	//게시글 좋아요 증가 
	//생성
	@Override
	public int BoardLike(HeartVO vo) throws Exception {
		return sqlSession.insert(namespace + ".BoardLike", vo);
	}
	//값 수정
	@Override
	public int BoardLikeUp(int b_no) throws Exception {
		return sqlSession.update(namespace + ".BoardLikeUp", b_no);
	}
	
	//게시글 좋아요 삭제 
	//삭제
	@Override
	public int BoardLikeDelete(HeartVO vo) throws Exception {
		return sqlSession.delete(namespace + ".BoardLikeDelete" , vo);
	}
	//값 수정
	@Override
	public int BoardLikeDown(int b_no) throws Exception {
		return sqlSession.update(namespace + ".BoardLikeDown", b_no);
	}

}
