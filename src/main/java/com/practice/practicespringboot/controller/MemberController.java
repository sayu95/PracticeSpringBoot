package com.practice.practicespringboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.practicespringboot.dto.MemberDTO;
import com.practice.practicespringboot.service.MemberService;

import lombok.RequiredArgsConstructor;

//@RestController는 사실 @Controller + @ResponseBody
//"이 메서드가 반환하는 데이터는 HTML 뷰(View)를 찾지 말고, 
//데이터 그 자체를 HTTP 응답 바디에 직접 때려 넣어라!"라는 뜻입니다.

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
//1. 롬복이 생성자를 만듦
public class MemberController {
	
	// 서비스 주입!
	private final MemberService memberService; 

    @GetMapping("/members")
    public List<MemberDTO> readMemberList() {
        return memberService.getMemberList();
    }
    
    @GetMapping("/member/{memId}")
    public MemberDTO readMember(@PathVariable("memId") long memId) {
        return memberService.getMember(memId);
    }
}
