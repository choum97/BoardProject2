package com.spring.ex.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.ex.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.spring.ex.MemberMapper";
	
	//전체 멤버 출력
	@Override
	public List<MemberVO> MemberList() throws Exception {
		return sqlSession.selectList(namespace + ".MemberList");
	}

	//회원 로그인
	@Override
	public MemberVO Login(MemberVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".MemberLogin", vo);
	}
}