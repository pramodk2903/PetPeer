package com.petstore.service;

import java.io.IOException;

import com.petstore.model.Employee;
import com.petstore.model.EmployeeList;

public interface EmployeeService {

	EmployeeList getEmployees() throws IOException;

	Employee getEmployee(int id) throws IOException;

	String saveEmployee(Employee employee);

}
