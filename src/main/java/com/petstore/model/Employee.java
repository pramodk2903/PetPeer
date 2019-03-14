package com.petstore.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class Employee implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String employee_name;
	private BigDecimal employee_salary;
	private int employee_age;
	private byte[] profile_image;

}
