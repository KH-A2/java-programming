package com.myhome.web.upload.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/upload")
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@PostMapping(value="/image", produces="application/json; charset=utf-8")
	@ResponseBody
	public String image(HttpServletRequest request
			, @RequestParam("upload") MultipartFile[] files
			, @RequestParam("type") String type) throws Exception {
		logger.info("image(files={}, type={})", files, type);
		
		JSONObject json = new JSONObject();
		
		String realPath = request.getServletContext().getRealPath("/resources");
		for(MultipartFile file: files) {
			json.put("uploaded", 1);
			json.put("fileName", file.getOriginalFilename());
			json.put("url", request.getContextPath() + "/static/img/board/" + file.getOriginalFilename());
			file.transferTo(new File(realPath + "/img/board/" + file.getOriginalFilename()));
		}
		
		return json.toJSONString();
	}
}
