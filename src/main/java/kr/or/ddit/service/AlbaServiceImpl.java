package kr.or.ddit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.dto.AlbaDTO;
import kr.or.ddit.mapper.AlbaMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbaServiceImpl implements AlbaService {

	private final AlbaMapper mapper;

	@Override
	public boolean addAlba(AlbaDTO alba) {
		// 비지니스 로직
		return mapper.insertAlba(alba) > 0;
	}

	@Override
	public List<AlbaDTO> getAllAlba() {
		// 비지니스 로직
		return mapper.selectAllAlba();
	}

	@Override
	public AlbaDTO getAlba(String alId) {
		// 비지니스 로직
		return mapper.selectAlba(alId);
	}

	@Override
	public boolean editAlba(AlbaDTO alba) {
		// 비지니스 로직
		return mapper.updateAlba(alba) > 0;
	}

	@Override
	public boolean removeAlbe(String alId) {
		// 비지니스 로직
		return mapper.deleteAlba(alId) > 0;
	}

}
