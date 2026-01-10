package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dto.LicenseDTO;

/**
 * Business Layer
 * License Interface
 */
public interface LicenseService {
	/**
	 * 모든자격증 조회서비스
	 * 초기화면에 DB의 등록된 자격증을 출력해주기 위한 조회서비스
	 * 
	 * @return 모든자격증 목록
	 */
	List<LicenseDTO> getAllLicense();
}
