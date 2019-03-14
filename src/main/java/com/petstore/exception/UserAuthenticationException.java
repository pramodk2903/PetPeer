package com.petstore.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class UserAuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String messae = "Invalid Username or Password";

	private HttpStatus status = HttpStatus.NOT_FOUND;

	public UserAuthenticationException(String message) {
		super(message);
	}

}
