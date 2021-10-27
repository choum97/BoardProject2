package com.spring.ex.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ex.vo.PhotoBoardVO;

@Repository
public class PhotoBoardDAOImpl implements PhotoBoardDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.spring.ex.PhotoBoardMapper";
	
	//게시글 작성
	@Override
	public int PhotoBoardWrite(PhotoBoardVO vo) throws Exception {
		return sqlSession.insert(namespace + ".PhotoBoardWrite", vo);
	}

	//게시글 수정
	@Override
	public int PhotoBoardModify(PhotoBoardVO vo) throws Exception {
		return sqlSession.update(namespace + ".PhotoBoardModify", vo);
		
	}

	//게시글 삭제
	@Override
	public int PhotoBoardDelete(int b_no) throws Exception {
		return sqlSession.delete(namespace + ".PhotoBoardDelete", b_no);
	}
	
	//게시글 이미지 파일이름 검색 - 파일 삭제하려고 사용
	@Override
	public String PhotoBoardFileName(int b_no) throws Exception {
		return sqlSession.selectOne(namespace + ".PhotoBoardFileName", b_no);
	}

	//게시글 출력
	@Override
	public List<PhotoBoardVO> PhotoBoardList(HashMap<String, Integer> map) throws Exception {
		return sqlSession.selectList(namespace + ".PhotoBoardList", map);
	}

	//게시글 조회
	@Override
	public PhotoBoardVO PhotoBoardDetailView(int b_no) throws Exception {
		return sqlSession.selectOne(namespace + ".PhotoBoardView", b_no);
	}

	//게시글 조회수 증가
	@Override
	public void PhotoBoardHit(int b_no) throws Exception {
		sqlSession.update(namespace + ".PhotoBoardHit", b_no);
	}

	//게시글 총 갯수 - 페이징
	@Override
	public int PhotoBoardTotalCount() throws Exception {
		return sqlSession.selectOne(namespace + ".getPhotoBoardTotalCount");
	}

}