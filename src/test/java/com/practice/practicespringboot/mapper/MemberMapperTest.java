package com.practice.practicespringboot.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.practice.practicespringboot.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Transactional
class MemberMapperTest {

	@Autowired
	private MemberMapper mapper;

	@Test
	void testreadMemberList() {
		// given
		
		// when
		List<MemberDTO> members = mapper.readMemberList();

		// 로그 활용: 조회된 리스트의 크기와 전체 내용 확인
		log.info("조회된 회원 수: {}", members.size());
		members.forEach(member -> log.debug("회원 정보: {}", member));

		// then
		assertThat(members)
				.as("members 객체는 항상 존재해야한다.")
				.isNotNull()
				.as("members은 비어있으면 안된다.").isNotEmpty()
				.extracting("memName").as("조회된 멤버들 중 '정선회'가 포함되어 있어야한다.").contains("정선회");
	}

	@Test
	void testreadMember() {
		// given
		long targetId = 1;
		log.info("회원 상세 조회 테스트 시작 - 대상 ID: {}", targetId);

		// when
		MemberDTO member = mapper.readMember(targetId);

		// then
		assertThat(member)
			.as("조회된 회원 객체는 null이 아니어야 한다.")
			.isNotNull();

		assertThat(member.getId())
			.as("조회된 회원의 ID는 요청한 ID와 일치해야 한다.")
			.isEqualTo(targetId);
	}
	
	@Test
	void testcreateMember() {
		//given
		MemberDTO member = MemberDTO.builder()
					.memId("a001")
					.memName("test")
					.memNick("test")
					.memPassword("java")
					.memEmail("test@test.com").build();
		
		//when
		int flag = mapper.createMember(member);
		
		//then
		assertThat(flag)
			.as("해당값은 1이여야 한다.")
			.isEqualTo(1);
	}
	
	@Test
	void testdeleteMember() { 
		//given
		long targetId = 4;
		
		int flag = mapper.deleteMember(targetId);
		
		assertThat(flag)
			.as("해당값은 1이여야한다.")
			.isEqualTo(1);
	}
}