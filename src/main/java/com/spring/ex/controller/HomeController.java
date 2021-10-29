package com.spring.ex.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.ex.service.PhotoBoardService;
import com.spring.ex.util.UploadFileUtils;
import com.spring.ex.vo.PagingVO;
import com.spring.ex.vo.PhotoBoardVO;

@Controller
public class HomeController {
	@Inject
	private PhotoBoardService service;
	
	//메인 페이지 이동
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	//메인 Home페이지 최근 게시글 출력
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String MainHomeBoardList(Model model, HttpServletRequest request) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		List<PhotoBoardVO> photoBoardList = service.PhotoBoardList(map);
		model.addAttribute("photoBoardList", photoBoardList);
		
		return "photoBoard";
	}
}
