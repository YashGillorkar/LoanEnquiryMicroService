package com.cjc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
	
	private String msg;
	private Date timestamp;
	
	

}
