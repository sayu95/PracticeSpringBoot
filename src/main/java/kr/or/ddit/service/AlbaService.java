package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dto.AlbaDTO;

public interface AlbaService {
	boolean addAlba(AlbaDTO alba);

	List<AlbaDTO> getAllAlba();

	AlbaDTO getAlba(String alId);

	boolean editAlba(AlbaDTO alba);

	boolean removeAlbe(String alId);

}
