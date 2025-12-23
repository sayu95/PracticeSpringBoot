package com.practice.practicespringboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.practicespringboot.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	int createMember(MemberDTO member);
	List<MemberDTO> readMemberList();
	MemberDTO readMember(long memId);
	int updateMember(MemberDTO member);
	int deleteMember(long memId);
}
