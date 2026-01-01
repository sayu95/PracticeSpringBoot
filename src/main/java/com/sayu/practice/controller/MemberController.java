package com.sayu.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sayu.practice.dto.MemberDTO;
import com.sayu.practice.service.MemberServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;
    
    @PostMapping("/login")
    @ResponseBody
    public String login(MemberDTO memberDTO, HttpSession session) {
        
        MemberDTO loginUser = memberService.login(memberDTO);
        
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
            return "success";
        } else {
            return "fail";
        }
    }
}