package kr.or.ddit.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dto.AlbaDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Transactional
class AlbaMapperTest {

	@Autowired
	private AlbaMapper mapper;

	@Test
	@DisplayName("알바생 등록")
	void testInsertAlba() {
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
		int result = mapper.insertAlba(alba);
		
		//then
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	@DisplayName("알바생 등록 후 검증 실패 케이스")
	@Disabled
	void testInsertAlbaFail() {
		//given
	    String alId = "A0000002";
	    AlbaDTO alba = AlbaDTO.builder()
	            .alId(alId)
	            .alName("김아무개")
	            .alAge(31)
	            .alZip("35220")
	            .alAddr1("대전광역시 중구")
	            .alAddr2("계룡로 846")
	            .alHp("010-1111-2222")
	            .grCode("G001")
	            .alGen("M")
	            .alMal("kim@example.com")
	            .build();
	    
	   
	    mapper.insertAlba(alba);
	    
	    //when
	    AlbaDTO savedAlba = mapper.selectAlba(alId);
	    
	    //then
	    assertThat(savedAlba.getAlName())
        	.isEqualTo("이순신");
	}

	@Test
	@DisplayName("전체 알바생 목록 조회")
	void testSelectAllAlba() {
		// given

		// when
		List<AlbaDTO> alba = mapper.selectAllAlba();

		// then
		assertThat(alba).isNotNull()
			.isNotEmpty()
			.hasSizeGreaterThan(0) // 사이즈가 0보다 큰지
			.extracting("alName")
			.contains("홍길동");
	}

	@Test
	@DisplayName("전체 알바생 목록 조회 후 검증 실패 케이스")
	@Disabled
	void testSelectAllAlbafail() {
		// given

		// when
		List<AlbaDTO> alba = mapper.selectAllAlba();

		// then
		assertThat(alba)
			.extracting("alName")
			.contains("존재하지않은이름");
	}

	@Test
	@DisplayName("알바 상세조회")
	void testSelectAlba() {
		// given
		String alId = "A0000002";

		// when
		AlbaDTO alba = mapper.selectAlba(alId);

		// then
		assertThat(alba)
			.isNotNull()
			.extracting("alId")
			.isEqualTo(alId);
	}

	@Test
	@DisplayName("알바 상세조회 후 검증 실패 케이스")
	@Disabled
	void testSelectAlbafail() {
		// given
		String alId = "A0000002";

		// when
		AlbaDTO alba = mapper.selectAlba(alId);

		// then
		assertThat(alba)
			.isNotNull()
			.extracting("alId")
			.isEqualTo("A0000333");
	}

	@Test
	@DisplayName("알바 업데이트")
	void testUpdateAlba() {
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
		int result = mapper.updateAlba(updateData);

		//then
		assertThat(result).as("수정된 행의 수가 1이어야 함").isEqualTo(1);
		
		AlbaDTO updatedAlba = mapper.selectAlba(alId);
		assertThat(updatedAlba.getAlHp()).isEqualTo("010-8888-7777");
		assertThat(updatedAlba.getAlDesc()).isEqualTo("경력직으로 수정되었습니다.");
	}
	
	@Test
	@DisplayName("알바 업데이트 후 검증 실패 케이스")
	@Disabled
	void testUpdateAlbafail() {
		//given
		String alId = "A0000002";
		AlbaDTO updateData = AlbaDTO.builder()
				.alId(alId)
			    .alZip("54321")                
			    .alAddr1("서울특별시 강남구")     
			    .alAddr2("테헤란로 123")        
			    .alHp("010-8888-7777")          
			    .alMal("updated_kim@test.com") 
			    .alCareer("경력 1년")            
			    .alSpec("SQLD, ADSP")          
			    .alDesc("경력직으로 수정되었습니다.")
			    .alImg("new_profile.jpg")     
			    .build();
		//when
		int result = mapper.updateAlba(updateData);
	    assertThat(result).isEqualTo(1);
	    
	    AlbaDTO updatedAlba = mapper.selectAlba(alId);
	    
	    assertThat(updatedAlba.getAlName())
        	.isEqualTo("경력 5년");
	}


	@Test
	@DisplayName("알바 삭제")
	void testDeleteAlba() {
		//given
		String alId = "A0000002";
		
		//when
		int result = mapper.deleteAlba(alId);
		
		//then
		assertThat(result).
			isEqualTo(1);
	}
	
	@Test
	@DisplayName("알바 삭제 후 검증 실패 케이스")
	@Disabled
	void testDeleteAlbafail() {
		//given
		String alId = "A0000002";
		
		//when
		int result = mapper.deleteAlba(alId);
		assertThat(result).isEqualTo(1);
		
		//then
		AlbaDTO deletedAlba = mapper.selectAlba(alId);
		
	    assertThat(deletedAlba)
	        .isNotNull();
	}
}
