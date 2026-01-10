package kr.or.ddit.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dto.LicenseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class LicenseMapperTest {
	
	@Autowired
	private LicenseMapper mapper;

	@Test
	@DisplayName("자격증 목록 조회")
	void testSelectAllLicense() {
		// given

		// when
		List<LicenseDTO> list = mapper.selectAllLicense();

		// then
		assertThat(list)
			.isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("licName")
			.contains("정보처리기사");
	}
	
	@Test
	@DisplayName("자격증 목록 조회 검증 실패 케이스")
	@Disabled
	void testSelectAllLicensefail() {
		// given

		// when
		List<LicenseDTO> list = mapper.selectAllLicense();

		// then
		assertThat(list)
			.isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("licName")
			.contains("한식조리기능사");
	}

}
