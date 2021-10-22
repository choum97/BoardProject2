package com.spring.ex.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex.service.MemberService;
import com.spring.ex.vo.MemberVO;

@Controller
public class BoardMainController {
	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String LoginView(Model model) throws Exception {
		//System.out.println(service.MemberList());
		System.out.println(service.MemberList());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(MemberVO vo, Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		System.out.println("로그인 웹 요청 ID : " + request.getParameter("m_userId"));
		System.out.println("로그인 웹 요청 PW : " + request.getParameter("m_pw"));
		
		MemberVO member = service.Login(vo);
		String resultPath = "";

        if(member != null) {
			session.setAttribute("member", member);
        	resultPath = "home";
        } else {
        	resultPath = "loginView";
        }

		
		return resultPath;
	}
	
	@RequestMapping(value = "/joinView", method = RequestMethod.GET)
	public String JoinView(Model model) throws Exception {
		
		return "join";
	}
}
