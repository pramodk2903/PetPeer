package com.petstore.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String messae = "No data found with given input";
	
	private HttpStatus status;
	
	public NoDataFoundException(String message) {
		super(message);
	}

}
