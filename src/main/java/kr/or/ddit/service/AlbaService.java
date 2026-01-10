package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dto.AlbaDTO;

/**
 * Business Layer
 * AlbaService Interface
 */
public interface AlbaService {
	/**
	 * 알바 등록서비스
	 * 
	 * @param alba 등록할 알바 정보
	 * @return 로직 성공여부 >> ResultSet 예외처리 필요
	 */
	boolean addAlba(AlbaDTO alba);

	/**
	 * 모든알바 조회서비스
	 * 
	 * @return 모든 알바 목록
	 */
	List<AlbaDTO> getAllAlba();

	/**
	 * 특정알바 조회서비스
	 * 
	 * @param alId 조회할 알바코드(PK)
	 * @return 조회된 알바의 정보
	 */
	AlbaDTO getAlba(String alId);

	/**
	 * 특정알바 수정서비스
	 * 
	 * @param alba 수정할 알바의 정보
	 * @return 로직 성공여부 >> ResultSet 예외처리 필요
	 */
	boolean editAlba(AlbaDTO alba);

	/**
	 * 특정알바 삭제서비스
	 * 
	 * @param alId 삭제할 알바코드(PK)
	 * @return 로직 성공여부 >> ResultSet 예외처리 필요
	 */
	boolean removeAlba(String alId);

}
