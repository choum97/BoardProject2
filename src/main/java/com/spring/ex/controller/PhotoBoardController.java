package com.spring.ex.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class PhotoBoardController {
	@Inject
	private PhotoBoardService service;
	
	String Path = "C:\\Users\\zeeko\\eclipse-workspace\\BoardProject2\\src\\main\\webapp\\resources\\images\\photoBoard/";
	//게시판 페이지 이동 및 게시판 목록 출력
	@RequestMapping(value = "/PhotoBoardListView", method = RequestMethod.GET)
	public String PhotoBoardList(Model model, HttpServletRequest request) throws Exception {
		int totalCount = service.PhotoBoardTotalCount();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		
		PagingVO paging = new PagingVO();
		paging.setPageNo(page);
		paging.setPageSize(9);
		paging.setTotalCount(totalCount);
		page = (page - 1) * 9;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Page", page);
		map.put("PageSize", paging.getPageSize());
		
		List<PhotoBoardVO> photoBoardList = service.PhotoBoardList(map);
		model.addAttribute("photoBoardList", photoBoardList);
		model.addAttribute("Paging", paging);
		
		return "photoBoard";
	}
	
	
	//게시글 조회 - 상세페이지 출력
	@RequestMapping(value = "/PhotoBoardDetailView", method = RequestMethod.GET)
	public String PhotoBoardDetailView(Model model, HttpServletRequest request)  throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		PhotoBoardVO photoBoardDetail = service.PhotoBoardDetailView(b_no);
		service.PhotoBoardHit(b_no);
		model.addAttribute("photoBoardDetail", photoBoardDetail);
		model.addAttribute("b_userId", photoBoardDetail.getB_userId());
		return "photoBoardDetail";
	}
	
	//게시글 삭제
	@RequestMapping(value = "/PhotoBoardDelete")
	public void PhotoBoardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String pfileName = service.PhotoBoardFileName(b_no);// 삭제할 파일 이름 가져오기
		
        File fileModifyDelete = new File(Path + pfileName); //삭제할 파일 경로
        
		if (fileModifyDelete.exists()) {
			if (fileModifyDelete.delete()) {
				System.out.println("파일삭제 성공");
			} else {
				System.out.println("파일삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}

		
		int result = service.PhotoBoardDelete(b_no); //DB에서 삭제
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(1 == result) {
			out.println("<script>");
			out.println("alert('삭제 성공.');");
			out.println("location.href='PhotoBoardListView';");
			out.println("</script>");
			out.close();
		} else {
			System.out.println("삭제 실패");
			out.println("<script>");
			out.println("alert('삭제 실패.');");
			out.println("location.reload();");
			out.println("</script>");
			out.close();
		}
	}
	
	//게시글 수정 페이지 이동
	@RequestMapping(value = "/PhotoBoardModifyView", method = RequestMethod.GET)
	public String PhotoBoardModifylView(Model model, HttpServletRequest request)  throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		PhotoBoardVO photoBoardDetail = service.PhotoBoardDetailView(b_no);
		
		model.addAttribute("photoBoardDetail", photoBoardDetail);
		return "photoBoardModify";
	}
	
	//게시글 수정
	@RequestMapping(value = "/PhotoBoardModify", method = RequestMethod.POST)
	public String PhotoBoardModify(PhotoBoardVO vo, MultipartFile file, HttpServletRequest request) throws Exception {
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(Path + request.getParameter("imgFile")).delete();
			String fileName = UploadFileUtils.fileUpload(Path, file.getOriginalFilename(), file.getBytes());
			
			vo.setB_file_name(fileName);
		}
		else {
			vo.setB_file_name(request.getParameter("imgFile"));
		}
		service.PhotoBoardModify(vo);
		
		return "redirect:PhotoBoardListView";
	}
}
