package com.spring.ex.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageMoveController {
	
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
	
}
