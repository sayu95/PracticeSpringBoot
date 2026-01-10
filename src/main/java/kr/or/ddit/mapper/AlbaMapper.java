package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.dto.AlbaDTO;

/**
 * Persistence Layer (DAO) Mybatis
 * AlbaMapper
 */
@Mapper
public interface AlbaMapper {
	/**
	 * 알바 등록 Mapper
	 * 
	 * @param alba 등록할 알바의 정보
	 * @return 등록된 알바 행의 수
	 */
	int insertAlba(AlbaDTO alba);

	/**
	 * 알바 전체조회 Mapper
	 * 
	 * @return 등록된 알바 전체조회
	 */
	List<AlbaDTO> selectAllAlba();

	/**
	 * 알바 상세조회 Mapper
	 * 
	 * @param alId 조회할 알바의 코드 (PK)
	 * @return 알바 한명을 상세조회
	 */
	AlbaDTO selectAlba(String alId);

	/**
	 * 알바 정보수정 Mapper
	 * 
	 * @param alba 수정할 알바의 정보
	 * @return 알바 한명을 수정
	 */
	int updateAlba(AlbaDTO alba);

	/**
	 * 알바 삭제 Mapper
	 * 
	 * @param alId 삭제할 알바의 코드 (PK)
	 * @return 삭제된 알바 행의 수
	 */
	int deleteAlba(String alId);
}
