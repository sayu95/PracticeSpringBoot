package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dto.GradeDTO;

/**
 * Business Layer
 * GradeService Interface
 */
public interface GradeService {
	/**
	 * 모든학력 조회서비스
	 * 초기화면에 DB의 등록된 학력을 출력해주기 위한 조회서비스
	 * 
	 * @return 모든학력 목록
	 */
	List<GradeDTO> getAllGrade();
}
