package kr.or.ddit.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LicAlbaDTO {
//	외래키
	@NotBlank
	private String alId;
//	외래키
	@NotBlank
	private String licCode;
	@NotBlank
	private LocalDate licDate;
	//이진 데이터는 byte[]로 담는다.
	private byte[] licImg;
}
