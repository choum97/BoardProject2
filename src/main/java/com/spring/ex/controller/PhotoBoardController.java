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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.ex.service.HeartService;
import com.spring.ex.service.PhotoBoardService;
import com.spring.ex.util.UploadFileUtils;
import com.spring.ex.vo.HeartVO;
import com.spring.ex.vo.MemberVO;
import com.spring.ex.vo.PagingVO;
import com.spring.ex.vo.PhotoBoardVO;

@Controller
public class PhotoBoardController {
	@Inject
	private PhotoBoardService boardService;
	private HeartService heartService;
	
	String Path = "C:\\Users\\zeeko\\eclipse-workspace\\BoardProject2\\src\\main\\webapp\\resources\\images\\photoBoard/";
	//게시판 페이지 이동 및 게시판 목록 출력
	@RequestMapping(value = "/PhotoBoardListView", method = RequestMethod.GET)
	public String PhotoBoardList(Model model, HttpServletRequest request) throws Exception {
		int totalCount = boardService.PhotoBoardTotalCount();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		
		PagingVO paging = new PagingVO();
		paging.setPageNo(page);
		paging.setPageSize(9);
		paging.setTotalCount(totalCount);
		page = (page - 1) * 9;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Page", page);
		map.put("PageSize", paging.getPageSize());
		
		List<PhotoBoardVO> photoBoardList = boardService.PhotoBoardList(map);
		model.addAttribute("photoBoardList", photoBoardList);
		model.addAttribute("Paging", paging);
		
		return "photoBoard";
	}
	
	
	//게시글 조회 - 상세페이지 출력
	@RequestMapping(value = "/PhotoBoardDetailView", method = RequestMethod.GET)
	public String PhotoBoardDetailView(Model model, HttpServletRequest request)  throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		PhotoBoardVO photoBoardDetail = boardService.PhotoBoardDetailView(b_no);
		boardService.PhotoBoardHit(b_no);
		
		model.addAttribute("photoBoardDetail", photoBoardDetail);
		model.addAttribute("b_userId", photoBoardDetail.getB_userId());
		return "photoBoardDetail";
	}
	
	//게시글 삭제
	@RequestMapping(value = "/PhotoBoardDelete")
	public void PhotoBoardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String pfileName = boardService.PhotoBoardFileName(b_no);// 삭제할 파일 이름 가져오기
		
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

		
		int result = boardService.PhotoBoardDelete(b_no); //DB에서 삭제
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
		PhotoBoardVO photoBoardDetail = boardService.PhotoBoardDetailView(b_no);
		
		model.addAttribute("photoBoardDetail", photoBoardDetail);
		return "photoBoardModify";
	}
	
	//게시글 수정
	@RequestMapping(value = "/PhotoBoardModify", method = RequestMethod.POST)
	public String PhotoBoardModify(PhotoBoardVO vo, MultipartFile file, HttpServletRequest request, HttpSession session) throws Exception {
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(Path + request.getParameter("imgFile")).delete();
			String fileName = UploadFileUtils.fileUpload(Path, file.getOriginalFilename(), file.getBytes());
			
		   //String path2 = session.getServletContext().getRealPath("/"); //이거로 하면 자동으로 새로고침은 됨
		   //System.out.println("■path:::"+path2);

			vo.setB_file_name(fileName);
		}
		else {
			vo.setB_file_name(request.getParameter("imgFile"));
		}
		boardService.PhotoBoardModify(vo);
		
		return "redirect:PhotoBoardListView";
	}
	
	//게시글 등록 페이지 이동
	@RequestMapping(value = "/PhotoBoardWriteView", method = RequestMethod.GET)
	public String PhotoBoardWriteView() {
		return "photoBoardWrite";
	}
	
	//게시글 등록
	@RequestMapping(value = "/PhotoBoardWrite", method = RequestMethod.POST)
	public String PhotoBoardWrite(PhotoBoardVO vo, MultipartFile file, HttpServletRequest request) throws Exception {
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName =  UploadFileUtils.fileUpload(Path, file.getOriginalFilename(), file.getBytes());	
		}

		vo.setB_file_name(fileName);
		boardService.PhotoBoardWrite(vo);
		
		return "redirect:PhotoBoardListView";
	}
	
	//게시글 좋아요 클릭여부 - 회원
	@RequestMapping(value = "/BoardLikeCheck", method = RequestMethod.GET)
	public int BoardLikeCheck(String m_userId) throws Exception {
		int result = heartService.BoardLikeCheck(m_userId);
		return result;
	}
	
	//게시글 좋아요 증가
	@RequestMapping(value = "/BoardLikeUp", method = RequestMethod.GET)
	public int BoardLikeUp(HeartVO vo) throws Exception {
		int result = 0;
		int resultBlikeNew = heartService.BoardLike(vo);
		int resultBlikeUp = heartService.BoardLikeUp(vo.getB_no());
		
		if(resultBlikeNew == 1 && resultBlikeUp == 1) {
			result = 1;
		}
		return result;
	}
	
	//게시글 좋아요 삭제
	@RequestMapping(value = "/BoardLikeDown", method = RequestMethod.GET)
	public int BoardLikeDown(HeartVO vo) throws Exception {
		int result = 0;
		int resultBlikeDel = heartService.BoardLikeDelete(vo);
		int resultBlikeDown = heartService.BoardLikeDown(vo.getB_no());
		
		if(resultBlikeDel == 1 && resultBlikeDown == 1) {
			result = 1;
		}
		return result;
	}
}
