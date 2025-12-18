package com.practice.practicespringboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.practicespringboot.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	List<MemberDTO> selectAllMembers();
}
