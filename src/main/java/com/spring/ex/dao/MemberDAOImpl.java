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
	
	//회원가입
	@Override
	public int SignUp(MemberVO vo) throws Exception {
		return sqlSession.insert(namespace + ".MemberSignUp", vo);
	}
	
	//회원가입 시 아이디 중복확인
	@Override
	public MemberVO IDCheck(String checkId) throws Exception {
		return sqlSession.selectOne(namespace + ".IDCheck", checkId);
	}
	
	//회원 로그인 시 lastDate 갱신
	@Override
	public int LoginDateRenewal(MemberVO vo) throws Exception {
		return sqlSession.update(namespace + ".MemberLoginDateLog", vo);
	}
}