package com.spring.ex.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.ex.vo.MemberVO;

@Repository
public interface MemberDAO {
	
	//전체 멤버 출력
	public List<MemberVO> MemberList() throws Exception;
	
	//회원 로그인
	public MemberVO Login(MemberVO vo) throws Exception;
	
	//회원가입
	public int SignUp(MemberVO vo) throws Exception;
	
	//회원가입 시 아이디 중복확인
	public MemberVO IDCheck(MemberVO vo) throws Exception;
	
	//회원 로그인 시 lastDate 갱신
	public int LoginDateRenewal(MemberVO vo) throws Exception;
	
}