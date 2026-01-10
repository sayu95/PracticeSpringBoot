package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.dto.GradeDTO;

/**
 * Persistence Layer (DAO) Mybatis
 * GradeMapper
 */
@Mapper
public interface GradeMapper {
	
	/**
	 * 학력 전체 조회 Mapper
	 * 
	 * @return 학력 전체조회
	 */
	List<GradeDTO> selectAllGrade();

}
