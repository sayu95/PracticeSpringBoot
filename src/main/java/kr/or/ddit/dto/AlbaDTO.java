package kr.or.ddit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbaDTO {
//	기본키
	@NotBlank
	private String alId;
	@NotBlank
	private String alName;
	@NotBlank
	private Integer alAge;
	@NotBlank
	private String alZip;
	@NotBlank
	private String alAddr1;
	@NotBlank
	private String alAddr2;
	@NotBlank
	private String alHp;
//	 외래키
	@NotBlank
	private String grCode;
	@NotBlank
	private String alGen;
	@NotBlank
	private String alMal;
	private String alCareer;
	private String alSpec;
	private String alDesc;
	private String alImg;
}
