package com.myhome.web.login.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myhome.web.dept.model.DeptDTO;
import com.myhome.web.dept.service.DeptService;
import com.myhome.web.login.service.LoginService;
import com.myhome.web.login.vo.LoginVO;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private DeptService deptService;
	
	/*
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model
			, @RequestParam("id") int empId
			, @RequestParam("deptId") int deptId
			, @RequestParam("name") String empName) {
		
		logger.info("empId : {}", empId);
		logger.info("deptId : {}", deptId);
		logger.info("empName : {}", empName);
		
		return "";
	}
	*/
	
	@GetMapping(value="/login")
	public String login(Model model) {
		List<DeptDTO> deptDatas = deptService.getAll();
		model.addAttribute("deptDatas", deptDatas);
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session, LoginVO loginVo, String deptRe, String url
			, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("login({}, {}, {}, {})", loginVo.getEmpId(), loginVo.getDeptId(), loginVo.getEmpName(), deptRe);
		
		boolean result = service.login(session, loginVo);
		
		if(result) {
			Cookie cookie;
			if(deptRe != null) {
				cookie = new Cookie("deptRe", String.valueOf(loginVo.getDeptId()));
				cookie.setMaxAge(60 * 60 * 24 * 5);
			} else {
				cookie = new Cookie("deptRe", "");
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			if(url.isEmpty()) {
				return "redirect:/index";
			} else {
				return "redirect:" + url.replaceFirst(request.getContextPath() + "/", "/");
			}
		} else {
			// 로그인 실패
			return login(model);
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		if(session.getAttribute("loginData") != null) {
			// 세션을 완전히 만료 시켜 새로운 새션이 만들어 지게 한다.
			// session.invalidate();
			
			// 기존 세션은 유지한 상태에서 로그인 정보만 제거하여 로그아웃 시킨다.
			session.removeAttribute("loginData");
		}
		return "redirect:/index";
	}
}
