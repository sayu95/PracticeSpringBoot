package com.practice.practicespringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.practicespringboot.dto.MemberDTO;
import com.practice.practicespringboot.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
// 서비스는 dao와 dependency 관계이기 때문에 생성자 주입이 필요하다.
public class MemberService {
	
	// (3) MemberService는 MemberDAO가 없으면 일을 못함 (의존성)
    private final MemberMapper mapper;
    
    public List<MemberDTO> getMemberList() {
    	/* 아래서부터 비지니스 로직 */
    	// 비즈니스 로직: 예를 들어 탈퇴한 회원은 제외하고 보여준다거나...
        return mapper.readMemberList();
    }

	public MemberDTO getMember(long memId) {
		/* 아래서부터 비지니스 로직 */
		return mapper.readMember(memId);
	}
	
	public boolean registerMember(MemberDTO member) {
		/* 아래서부터 비지니스 로직 */
		return mapper.createMember(member) > 0;
	}
	
	public boolean modifyMember(MemberDTO member) {
		/* 아래서부터 비지니스 로직 */
	    return mapper.updateMember(member) > 0;
	}
	
	public boolean removeMember(long memId) {
		/* 아래서부터 비지니스 로직 */
	    return mapper.deleteMember(memId) > 0;
	}
	
}
