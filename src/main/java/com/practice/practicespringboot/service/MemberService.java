package com.practice.practicespringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.practicespringboot.dao.MemberDAO;
import com.practice.practicespringboot.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
// (1) 롬복이 생성자를 만듦
// (2) 생성자 주입
// 서비스는 dao와 dependency 관계이기 때문에 생성자 주입이 필요하다.
public class MemberService {
	
	// (3) MemberService는 MemberDAO가 없으면 일을 못함 (의존성)
    private final MemberDAO memberDAO;
    
    public List<MemberDTO> getAllMembers() {
    	/* 아래서부터 비지니스 로직 */
    	// 비즈니스 로직: 예를 들어 탈퇴한 회원은 제외하고 보여준다거나...
        return memberDAO.selectAllMembers(); // DAO에 일 시키기
    }
}
