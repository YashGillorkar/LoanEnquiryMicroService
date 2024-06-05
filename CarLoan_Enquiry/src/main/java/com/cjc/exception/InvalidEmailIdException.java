package com.cjc.exception;

public class InvalidEmailIdException extends RuntimeException {

	public InvalidEmailIdException(String msg) {
		super(msg);
	}
}
