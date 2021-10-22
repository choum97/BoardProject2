package com.spring.ex.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex.service.MemberService;
import com.spring.ex.vo.MemberVO;

@Controller
public class BoardMainController {
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
		//System.out.println(service.MemberList());
		System.out.println(service.MemberList());
		return "login";
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
			System.out.println("성공");
			session.setAttribute("member", member);
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
	
	@RequestMapping(value = "/joinView", method = RequestMethod.GET)
	public String JoinView(Model model) throws Exception {
		
		return "join";
	}
}
