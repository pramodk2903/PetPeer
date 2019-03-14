package com.petstore.controller.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter @NoArgsConstructor
@ToString
public class ApiErrorVO {

	private String errorCode;
	private String message;

	public ApiErrorVO(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
}
