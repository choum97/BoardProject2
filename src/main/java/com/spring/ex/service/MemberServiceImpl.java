package com.spring.ex.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.ex.dao.MemberDAO;
import com.spring.ex.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;
	
	//전체 멤버 출력
	@Override
	public List<MemberVO> MemberList() throws Exception {
		return dao.MemberList();
	}

	//회원 로그인
	@Override
	public MemberVO Login(MemberVO vo) throws Exception {
		return dao.Login(vo);
	}
}