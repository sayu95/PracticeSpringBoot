package com.practice.practicespringboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.practicespringboot.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	List<MemberDTO> selectMemberList();
	MemberDTO selectMember(long memId);
	boolean createMember(MemberDTO member);
	boolean deleteMember(long memId);
}
