package com.sayu.practice.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberDTO {
	private Integer Id;
    private String memId;       
    private String memPassword; 
    private String memName;     
    private String memNick;
    private String memEmail;    
    private LocalDate memCreateat;
}
