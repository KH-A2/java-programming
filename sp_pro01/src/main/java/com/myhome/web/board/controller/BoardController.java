package com.myhome.web.board.controller;

import java.io.IOException;
import java.sql.SQLDataException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.service.BoardService;
import com.myhome.web.board.vo.BoardVO;
import com.myhome.web.comment.model.CommentDTO;
import com.myhome.web.comment.service.CommentService;
import com.myhome.web.common.util.Paging;
import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.upload.model.FileUploadDTO;
import com.myhome.web.upload.service.FileUploadService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private FileUploadService fileUploadService;

	// 조회 목록
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getData(Model model, HttpSession session
			, HttpServletResponse response
			, @RequestParam(defaultValue="1", required=false) int page
			, @RequestParam(defaultValue="0", required=false) int pageCount) throws IOException {
		if(session.getAttribute("pageCount") == null) {
			session.setAttribute("pageCount", 5);
		}
		
		if(pageCount > 0) {
			session.setAttribute("pageCount", pageCount);
		}
		
		// List<BoardDTO> datas = service.getAll();
		Paging pageData = null;
		// try {
			pageData = service.getPage(session, page, Integer.parseInt(session.getAttribute("pageCount").toString()));
			model.addAttribute("pageData", pageData);
			model.addAttribute("datas", pageData.getPageDatas());
			return "board/list";
		// } catch (Exception e) {
		// 	response.sendError(403, "권한이 없습니다.");
		// 	return null;
		// }
	}
	
	// 조회 상세
	// @RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	// public String getDetail(Model model
	// 		, @PathVariable int id) {
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String getDetail(Model model, HttpSession session
			, @SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int id) throws RuntimeException {
		
		BoardDTO data = service.getData(session, id);
		List<FileUploadDTO> fileDatas = fileUploadService.getDatas(id);
		
		if(data == null) {
			model.addAttribute("error", "해당 데이터는 존재하지 않습니다.");
			return "error/noExists";
		} else {
			service.incViewCnt(empDto, data);
			model.addAttribute("data", data);
			model.addAttribute("fileDatas", fileDatas);
			return "board/detail";
		}
	}
	
	// 추가 폼 요청
	@GetMapping(value="/add")
	public String add(@SessionAttribute(name="loginData", required=true) EmpDTO empDto) {
		return "board/add";
	}
	
	// 추가 저장 요청
	@PostMapping(value="/add")
	public String add(HttpServletRequest request, HttpSession session
			, @ModelAttribute BoardVO boardVo
			, @SessionAttribute(name="loginData", required=true) EmpDTO empDto
			, @RequestParam("upload") MultipartFile[] files) throws Exception {
		int id = service.add(session, empDto, boardVo);
		
		if(id > 0) {
			if(!files[0].getOriginalFilename().isEmpty()) {
				String location = request.getServletContext().getRealPath("/resources/upload/board");
				String url = "/static/upload/board";
				FileUploadDTO fileUploadDto = new FileUploadDTO(id, location, url);
				int result = fileUploadService.upload(files, fileUploadDto);
			}
			return "redirect:/board/detail?id=" + id;
		} else {
			return "board/add";
		}
	}
	
	// 수정 폼 요청
	@GetMapping(value="/modify")
	public String modify(Model model, HttpSession session
			, @SessionAttribute(name="loginData", required=true) EmpDTO empDto
			, @RequestParam int id) {
		
		BoardDTO data = service.getData(session, id);
		List<FileUploadDTO> fileDatas = fileUploadService.getDatas(id);
		
		if(empDto.getEmpId() == data.getEmpId()) {
			model.addAttribute("data", data);
			model.addAttribute("fileDatas", fileDatas);
			return "board/modify";
		} else {
			model.addAttribute("error", "해당 작업을 수행 할 권한이 없습니다.");
			return "error/permission";
		}
	}
	
	// 수정 저장 요청
	@PostMapping(value="/modify")
	public String modify(Model model, HttpSession session
			, @SessionAttribute(name="loginData", required=true) EmpDTO empDto
			, @ModelAttribute BoardVO boardVo) {
		
		BoardDTO data = service.getData(session, boardVo.getId());
		
		if(empDto.getEmpId() == data.getEmpId()) {
			data.setTitle(boardVo.getTitle());
			data.setContent(boardVo.getContent());
			boolean result = service.modify(session, data);
			if(result) {
				return "redirect:/board/detail?id=" + data.getId();
			} else {
				return "board/modify";
			}
		} else {
			model.addAttribute("error", "해당 작업을 수행 할 권한이 없습니다.");
			return "error/permissions";
		}
		
	}
	
	// 삭제
	@PostMapping(value="/delete", produces="application/json; charset=utf-8")
	@ResponseBody
	public String delete(HttpSession session
			, @SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int id) {
		
		BoardDTO data = service.getData(session, id);
		
		JSONObject json = new JSONObject();
		
		if(data == null) {
			// 이미 삭제가 되었음.
			json.put("title", "삭제가 된 데이터");
			json.put("message", "해당 데이터는 이미 삭제가 되었습니다.");
			return json.toJSONString();
		} else {
			if(data.getEmpId() == empDto.getEmpId()) {
				// 삭제 가능
				boolean result = service.remove(session, data);
				if(result) {
					json.put("title", "삭제 완료");
					json.put("message", "삭제 처리가 완료되었습니다.");
					return json.toJSONString();
				} else {
					json.put("title", "삭제 실패");
					json.put("message", "삭제 작업중 알 수 없는 문제가 발생하였습니다.");
					return json.toJSONString();
				}
			} else {
				// 작성자 불일치 - 삭제 불가 - 권한 없음
				json.put("title", "삭제 불가");
				json.put("message", "해당 데이터를 삭제할 권한이 없습니다.");
				return json.toJSONString();
			}
		}
	}
	
	@PostMapping(value="/comment/add")
	public String commentAdd(Model model, HttpSession session
			, @SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int bid
			, @RequestParam String content) {
		
		CommentDTO data = new CommentDTO();
		data.setbId(bid);
		data.setContent(content);
		data.setEmpId(empDto.getEmpId());
		
		boolean result = commentService.add(data);
		
		if(result) {
			return "redirect:/board/detail?id=" + bid;
		} else {
			session.setAttribute("commentError", "댓글 추가 작업 중 문제가 발생하였습니다.");
			return "redirect:/board/detail?id=" + bid;
		}
		
	}
	
	// 추천
	@PostMapping(value="/like", produces="application/json; charset=utf-8")
	@ResponseBody
	public String like(HttpSession session
			, @SessionAttribute("loginData") EmpDTO empDto
			, @RequestParam int id) {
		BoardDTO data = service.getData(session, id);
		
		JSONObject json = new JSONObject();
		
		if(data == null) {
			json.put("code", "noData");
			json.put("message", "데이터가 존재하지 않습니다.");
		} else {
			try {
				service.addLike(session, empDto, data);
				json.put("code", "success");
				json.put("message", "데이터 처리가 완료되었습니다.");
				json.put("likeCnt", data.getLike());
			} catch(SQLDataException e) {
				json.put("code", "fail");
				json.put("title", "오류");
				json.put("message", "데이터 처리 중 문제가 발생했습니다.");
			}
		}
		return json.toJSONString();
	}
	
}
