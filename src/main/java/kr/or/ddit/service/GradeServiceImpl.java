package kr.or.ddit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.dto.GradeDTO;
import kr.or.ddit.mapper.GradeMapper;
import lombok.RequiredArgsConstructor;

/**
 * Business Layer Impl
 * 다형성을 위한 역할과 구현체의 분리
 */
@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
	
	/**
	 * 생성자 주입(RAC)
	 * Service는 반드시 Mapper가 필요 -> 필수 의존관계
	 */
	private final GradeMapper mapper;

	/**
	 * Business Layer의 GradeService.getAllGrade() 구현체
	 * 모든 학력조회
	 * 초기화면에 DB의 등록된 학력을 출력해주기 위한 조회서비스
	 */
	@Override
	public List<GradeDTO> getAllGrade() {
		return mapper.selectAllGrade();
	}
}
