package com.spring.ex.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.service.PhotoBoardService;
import com.spring.ex.vo.PagingVO;
import com.spring.ex.vo.PhotoBoardVO;

@Controller
public class PhotoBoardController {
	@Inject
	private PhotoBoardService service;
	
	//여행패키지 출력
	@RequestMapping(value = "/PhotoBoardView", method = RequestMethod.GET)
	public String PhotoBoardView(Model model, HttpServletRequest request) throws Exception {
		
		int totalCount = service.PhotoBoardTotalCount();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		System.out.println(totalCount);
		
		PagingVO paging = new PagingVO();
		paging.setPageNo(page);
		paging.setPageSize(10);
		paging.setTotalCount(totalCount);
		page = (page - 1) * 10;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Page", page);
		map.put("PageSize", paging.getPageSize());
		
		
		List<PhotoBoardVO> photoBoardList = service.PhotoBoardList(map);
		System.out.println(photoBoardList);
		model.addAttribute("plist", photoBoardList);
		model.addAttribute("Paging", paging);
		
		return "photoBoard";
		
	}
	
}
