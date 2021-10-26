package com.spring.ex.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spring.ex.vo.MemberVO;

@Service
public interface MemberService {
	
	//전체 멤버 출력
	public List<MemberVO> MemberList() throws Exception;
	
	//회원 로그인
	public MemberVO Login(MemberVO vo) throws Exception;
	
	//회원 로그아웃
	public void logout(HttpServletResponse response) throws Exception;
	
	//회원가입
	public int SignUp(MemberVO vo) throws Exception;
	
	//회원가입 시 아이디 중복확인
	public MemberVO IDCheck(String checkId) throws Exception;
	
	//회원 로그인 시 lastDate 갱신
	public int LoginDateRenewal(MemberVO vo) throws Exception;
}