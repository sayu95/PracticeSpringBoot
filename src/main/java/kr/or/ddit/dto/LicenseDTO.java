package kr.or.ddit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LicenseDTO {
//	기본키
	@NotBlank
	private String licCode;
	@NotBlank
	private String licName;
}
