package com.spring.ex.controller;

import java.io.PrintWriter;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ex.service.MemberService;
import com.spring.ex.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	private MemberService service;
	
	//메인 페이지 이동
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	//로그인 페이지 이동
	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String LoginView(Model model) throws Exception {
		return "login";
	}
	
	//회원가입 페이지 이동
	@RequestMapping(value = "/SignUpMemberView", method = RequestMethod.GET)
	public String SignUpMemberView(Model model) throws Exception {
		return "join";
	}
	
	//로그인 실행
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody int Login(MemberVO vo, Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		int result = 0;
		System.out.println("로그인 웹 요청 ID : " + request.getParameter("m_userId"));
		System.out.println("로그인 웹 요청 PW : " + request.getParameter("m_pw"));
		
		MemberVO member = service.Login(vo);
		
		if (member != null) {
			session.setAttribute("member", member);
			service.LoginDateRenewal(vo);
			result = 1;
		}
		return result;
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {
		session.invalidate();
		service.logout(response);
	}
	
	//회원가입
	@RequestMapping(value = "/SignUpMember", method = RequestMethod.POST)
	public void SignUpMember(MemberVO vo, Model model, HttpServletRequest request,  HttpServletResponse response) throws Exception {
		int result = service.SignUp(vo);
		HttpSession session = request.getSession();
		
		if (result == 1) {
			//session.setAttribute("member", vo);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 되었습니다.');");
			out.println("location.href='home';");
			out.println("</script>");
			out.close();
		}
	}
	
	//회원가입 아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/IDCheck", method = RequestMethod.POST)
	public int IDCheck(String m_userId) throws Exception {
		int result = 0;
		
		MemberVO IDCheck = service.IDCheck(m_userId);
		if (IDCheck == null) {
			result = 1;
		}
		return result;
	}
	
}
