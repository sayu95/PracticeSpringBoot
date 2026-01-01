package com.sayu.practice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sayu.practice.dto.MemberDTO;

@Mapper
public interface MemberMapper {
    MemberDTO login(MemberDTO memberDTO);
}