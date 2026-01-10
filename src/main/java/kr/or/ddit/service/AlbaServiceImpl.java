package kr.or.ddit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.dto.AlbaDTO;
import kr.or.ddit.mapper.AlbaMapper;
import lombok.RequiredArgsConstructor;

/**
 * Business Layer Impl
 * 다형성을 위한 역할과 구현체의 분리
 */
@Service
@RequiredArgsConstructor
public class AlbaServiceImpl implements AlbaService {

	/**
	 * 생성자 주입(RAC)
	 * Service는 반드시 Mapper가 필요 -> 필수 의존관계
	 */
	private final AlbaMapper mapper;

	/**
	 * Business Layer의 AlbaService.addAlba() 구현체
	 * 알바등록
	 */
	@Override
	public boolean addAlba(AlbaDTO alba) {
		// 비지니스 로직
		return mapper.insertAlba(alba) > 0;
	}

	/**
	 * Business Layer의 AlbaService.getAllAlba() 구현체
	 * 모든 알바 조회
	 */
	@Override
	public List<AlbaDTO> getAllAlba() {
		// 비지니스 로직
		return mapper.selectAllAlba();
	}

	/**
	 * Business Layer의 AlbaService.getAlba() 구현체
	 * 특정 알바 조회
	 */
	@Override
	public AlbaDTO getAlba(String alId) {
		// 비지니스 로직
		return mapper.selectAlba(alId);
	}

	/**
	 * Business Layer의 AlbaService.editAlba() 구현체
	 * 특정 알바 수정
	 */
	@Override
	public boolean editAlba(AlbaDTO alba) {
		// 비지니스 로직
		return mapper.updateAlba(alba) > 0;
	}

	/**
	 * Business Layer의 AlbaService.removeAlba() 구현체
	 * 특정 알바 삭제
	 */
	@Override
	public boolean removeAlba(String alId) {
		// 비지니스 로직
		return mapper.deleteAlba(alId) > 0;
	}

}
