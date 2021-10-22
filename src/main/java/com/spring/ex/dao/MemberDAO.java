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
	
}