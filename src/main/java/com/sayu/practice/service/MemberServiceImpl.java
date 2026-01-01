package com.sayu.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayu.practice.dto.MemberDTO;
import com.sayu.practice.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MembreService {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 로그인 처리 로직
     * @param memberDTO 사용자가 입력한 id, password
     * @return 로그인 성공 시 회원정보(DTO), 실패 시 null
     */
    public MemberDTO login(MemberDTO memberDTO) {
        return memberMapper.login(memberDTO);
    }
}