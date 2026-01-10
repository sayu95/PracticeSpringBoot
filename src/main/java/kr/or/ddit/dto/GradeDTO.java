package kr.or.ddit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GradeDTO {
//	기본키
	@NotBlank
	private String grCode;
	@NotBlank
	private String grName;
}
