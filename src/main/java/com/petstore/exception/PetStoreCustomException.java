package com.petstore.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter	@Getter	@NoArgsConstructor
public class PetStoreCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private HttpStatus status;
	
	public PetStoreCustomException(String message) {
		super(message);
	}
	
	public PetStoreCustomException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
}
