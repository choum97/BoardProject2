package com.spring.ex.service;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

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
	
	//회원 로그아웃
	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>location.href='home';</script>");
		out.close();
	}
	
	//회원가입
	@Override
	public int SignUp(MemberVO vo) throws Exception {
		return dao.SignUp(vo);
	}

	//회원가입 시 아이디 중복확인
	@Override
	public MemberVO IDCheck(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.IDCheck(vo);
	}
	
	//회원 로그인 시 lastDate 갱신
	@Override
	public int LoginDateRenewal(MemberVO vo) throws Exception {
		return dao.LoginDateRenewal(vo);
	}
}