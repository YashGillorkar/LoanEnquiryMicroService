package com.cjc.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.dto.ResponseDto;
import com.cjc.exception.InvalidEmailIdException;
import com.cjc.exception.InvalidFristNameException;
import com.cjc.exception.InvalidLastNameException;
import com.cjc.exception.InvalidMiddleNameException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidFristNameException.class)
	public ResponseEntity<ResponseDto> incorretFristName(InvalidFristNameException e){
		ResponseDto rr = new ResponseDto(e.getMessage(), new Date());
		return new ResponseEntity<ResponseDto>(rr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidMiddleNameException.class)
	public ResponseEntity<ResponseDto> incorreMiddletName(InvalidMiddleNameException e){
		ResponseDto rr = new ResponseDto(e.getMessage(), new Date());
		return new ResponseEntity<ResponseDto>(rr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidLastNameException.class)
	public ResponseEntity<ResponseDto> incorretLastName(InvalidLastNameException e){
		ResponseDto rr = new ResponseDto(e.getMessage(), new Date());
		return new ResponseEntity<ResponseDto>(rr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEmailIdException.class)
	public ResponseEntity<ResponseDto> incorretEmailName(InvalidEmailIdException e){
		ResponseDto rr = new ResponseDto(e.getMessage(), new Date());
		return new ResponseEntity<ResponseDto>(rr,HttpStatus.BAD_REQUEST);
	}

}
