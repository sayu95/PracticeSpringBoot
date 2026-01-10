package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.dto.AlbaDTO;

@Mapper
public interface AlbaMapper {
	int insertAlba(AlbaDTO alba);
	List<AlbaDTO> selectAllAlba();
	AlbaDTO selectAlba(String alId);
	int updateAlba(AlbaDTO alba);
	int deleteAlba(String alId);
}
