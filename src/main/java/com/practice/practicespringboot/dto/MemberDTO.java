package com.practice.practicespringboot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberDTO {
	private long Id;
	private String memId;
	private String memName;   
	private String memPassword;    
	private String memEmail;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;
}
