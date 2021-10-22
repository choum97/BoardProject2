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
	
}