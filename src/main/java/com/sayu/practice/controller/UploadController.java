package com.sayu.practice.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String uploadPage() {
		return "upload"; // upload.jsp로 이동
	}

	@PostMapping("/upload/action")
	@ResponseBody
	public String uploadAction(MultipartFile uploadFile) {
	    String uploadFolder = "C:/upload/temp";
	    
	    // 1. 랜덤값 생성 (파일 중복 방지)
	    String uuid = UUID.randomUUID().toString();
	    // 2. 실제 저장될 파일명 : uuid_원본이름
	    String saveFileName = uuid + "_" + uploadFile.getOriginalFilename();
	    
	    File saveFile = new File(uploadFolder, saveFileName);

	    try {
	        uploadFile.transferTo(saveFile);
	        return "ok";
	    } catch (Exception e) {
	        return "fail";
	    }
	}
}