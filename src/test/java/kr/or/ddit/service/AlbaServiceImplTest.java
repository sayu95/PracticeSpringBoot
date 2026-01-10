package kr.or.ddit.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dto.AlbaDTO;
import kr.or.ddit.mapper.AlbaMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Transactional
class AlbaServiceImplTest {
	
	@Autowired
	private AlbaService service;
	
	@Test
	@DisplayName("알바생 등록 서비스")
	void testaddAlba() {
		
		// given
		AlbaDTO alba = AlbaDTO.builder()
				.alName("김아무개")
				.alAge(31)
				.alZip("35220")
				.alAddr1("대전광역시 중구")
				.alAddr2("계룡로 846")
				.alHp("010-1111-2222")
				.grCode("G001")
				.alGen("M")
				.alMal("kim@example.com")
				.alCareer("경력 2년")
				.alSpec("정보처리기사")
				.alDesc("성실한 인재입니다.").build();
		
		//when
		boolean result = service.addAlba(alba);
		
		//then
		assertThat(result).isEqualTo(true);
	}
	
	@Test
	@DisplayName("알바생 등록 서비스 검증 실패 케이스")
	@Disabled
	void testaddAlbafail() {
		
		// given
		AlbaDTO alba = AlbaDTO.builder()
				.alName("김아무개")
				.alAge(31)
				.alZip("35220")
				.alAddr1("대전광역시 중구")
				.alAddr2("계룡로 846")
				.alHp("010-1111-2222")
				.grCode("G001")
				.alGen("M")
				.alMal("kim@example.com")
				.alCareer("경력 2년")
				.alSpec("정보처리기사")
				.alDesc("성실한 인재입니다.").build();
		
		//when
		boolean result = service.addAlba(alba);
		
		//then
		assertThat(result).isEqualTo(false);
	}

	@Test
	@DisplayName("Alba 목록 서비스")
	void testGetAllAlba() {
		//given
		
		//when
		List<AlbaDTO> list = service.getAllAlba();
		
		//then
		assertThat(list)
			.isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("alName")
			.contains("홍길동");
	}
	
	@Test
	@DisplayName("Alba 목록 서비스 검증 실패 케이스")
	@Disabled
	void testGetAllAlbafail() {
		//given
		
		//when
		List<AlbaDTO> list = service.getAllAlba();
		
		//then
		assertThat(list)
			.isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("alName")
			.contains("존재하지않은이름");
	}

	@Test
	@DisplayName("알바 상세조회 서비스")
	void testgetAlba() {
		// given
		String alId = "A0000002";

		// when
		AlbaDTO alba = service.getAlba(alId);

		// then
		assertThat(alba)
			.isNotNull()
			.extracting("alId")
			.isEqualTo(alId);
	}
	
	@Test
	@DisplayName("알바 상세조회 서비스 검증 실패 케이스")
	@Disabled
	void testgetAlbafail() {
		// given
		String alId = "A0000002";

		// when
		AlbaDTO alba = service.getAlba(alId);

		// then
		assertThat(alba)
			.isNotNull()
			.extracting("alId")
			.isNotEqualTo(alba);
	}

	@Test
	@DisplayName("알바 업데이트 서비스")
	@Disabled
	void testEditAlba() {
		//given
		String alId = "A0000002";
		
		AlbaDTO updateData = AlbaDTO.builder()
				.alId(alId)
	            .alZip("54321")                
	            .alAddr1("서울특별시 강남구")     
	            .alAddr2("테헤란로 123")        
	            .alHp("010-8888-7777")          
	            .alMal("updated_kim@test.com") 
	            .alCareer("경력 5년")            
	            .alSpec("SQLD, ADSP")          
	            .alDesc("경력직으로 수정되었습니다.")
	            .alImg("new_profile.jpg")     
	            .build();
		//when
		boolean result = service.editAlba(updateData);
		
		//then
		assertThat(result)
			.isNotNull()
			.isEqualTo(true);
	}
	
	@Test
	@DisplayName("알바 업데이트 서비스 검증 실패 케이스")
	@Disabled
	void testEditAlbafail() {
		//given
		String alId = "A0000005";
		
		AlbaDTO updateData = AlbaDTO.builder()
				.alId(alId)
	            .alZip("54321")                
	            .alAddr1("서울특별시 강남구")     
	            .alAddr2("테헤란로 123")        
	            .alHp("010-8888-7777")          
	            .alMal("updated_kim@test.com") 
	            .alCareer("경력 5년")            
	            .alSpec("SQLD, ADSP")          
	            .alDesc("경력직으로 수정되었습니다.")
	            .alImg("new_profile.jpg")     
	            .build();
		//when
		boolean result = service.editAlba(updateData);
		
		//then
		assertThat(result)
			.isNotNull()
			.isEqualTo(true);
	}

	@Test
	@DisplayName("알바 삭제 서비스")
	void testRemoveAlbe() {
		//given
		String alId = "A0000002";
		
		//when
		boolean result = service.removeAlba(alId);
		
		//then
		assertThat(result)
			.isNotNull()
			.isEqualTo(true);
	}
	
	@Test
	@DisplayName("알바 삭제 서비스 검증 실패 케이스")
	@Disabled
	void testRemoveAlbefail() {
		//given
		String alId = "A0000002";
		
		//when
		boolean result = service.removeAlba(alId);
		
		//then
		assertThat(result)
			.isEqualTo(false);
	}
}
