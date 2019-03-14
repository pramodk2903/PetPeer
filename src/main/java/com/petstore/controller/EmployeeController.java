package com.petstore.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petstore.model.Employee;
import com.petstore.model.EmployeeList;
import com.petstore.service.EmployeeService;

@RestController
@RequestMapping(path = "/empApi")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(path="/employee/{id}")
	public ResponseEntity<Employee> getPet(@PathVariable int id) throws IOException
	{
		logger.info("pets");
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	@GetMapping(path="/employees")
	public ResponseEntity<EmployeeList> getPets() throws IOException
	{
		logger.info("pets");
		return new ResponseEntity<EmployeeList>(employeeService.getEmployees(), HttpStatus.OK);
	}
	
}
