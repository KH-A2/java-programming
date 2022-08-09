package com.myhome.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService service;

	// 조회
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getData(Model model) {
		
		List<BoardDTO> datas = service.getAll();
		model.addAttribute("datas", datas);
		
		return "board/list";
	}
	
	// 추가 폼 요청
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model) {
		return "";
	}
	
	// 추가 저장 요청
	// @RequestMapping(value="/add", method=RequestMethod.POST)
	// public String add(BoardVO boardVo) {
	// 	return "";
	// }
	
	// 수정 폼 요청
	// @RequestMapping(value="/modify", method=RequestMethod.GET)
	
	// 수정 저장 요청
	// @RequestMapping(value="/modify", method=RequestMethod.POST)
	
	// 삭제
	
}
