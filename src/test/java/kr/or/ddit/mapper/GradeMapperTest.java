package kr.or.ddit.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dto.GradeDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class GradeMapperTest {
	
	@Autowired
	private GradeMapper mapper;

	@Test
	@DisplayName("학력 목록 조회")
	void testSelectAllGrade() {
		// given

		// when
		List<GradeDTO> list = mapper.selectAllGrade();

		// then
		assertThat(list).isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("grName")
			.contains("고졸");
	}
	
	@Test
	@DisplayName("학력 목록 조회 검증 실패 케이스")
	@Disabled
	void testSelectAllGradefail() {
		// given

		// when
		List<GradeDTO> list = mapper.selectAllGrade();

		// then
		assertThat(list).isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("grName")
			.contains("덴지쿤 사실 난 학교를 다닌적이 없어");
	}

}
