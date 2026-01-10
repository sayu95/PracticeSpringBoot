package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.dto.LicenseDTO;

/**
 * Persistence Layer (DAO) Mybatis
 * LicenseMapper
 */
@Mapper
public interface LicenseMapper {
	
	/**
	 * 자격증 전체 조회 Mapper
	 * 
	 * @return 자격증 전체조회
	 */
	List<LicenseDTO> selectAllLicense();
}
