package com.petstore.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.model.Employee;
import com.petstore.model.EmployeeList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public EmployeeList getEmployees() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.ALL));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		
		String response = 
		 restTemplate.exchange("http://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET, entity, String.class).getBody();
		 
		logger.info("response : \n " + response);
//		ObjectMapper mapper = new ObjectMapper();
//		EmployeeList employeeList = mapper.readValue(response, EmployeeList.class);
		
		
//		EmployeeList employeeList = restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees", EmployeeList.class);
//		Employee[] employees = restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees", Employee[].class);
//		logger.info("employees : \n " + employees);
		EmployeeList employeeList = new EmployeeList();
//		employeeList.setEmployees(employees);
		
		ResponseEntity<List<Employee>> responseVal = restTemplate.exchange(
				"http://dummy.restapiexample.com/api/v1/employees",
				  HttpMethod.GET,
				  null,
				  new ParameterizedTypeReference<List<Employee>>(){});
				List<Employee> employeesList = responseVal.getBody();
				employeeList.setEmployeesList(employeesList);
		
		 return employeeList;
	}

	@Override
	public String saveEmployee(Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <Employee> entity = new HttpEntity<Employee>(employee, headers);
		
		String response = 
		 restTemplate.exchange("http://dummy.restapiexample.com/api/v1/create", HttpMethod.POST, entity, String.class).getBody();
		 
		 return response;
	}

	@Override
	public Employee getEmployee(int id) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		
		String response = 
		 restTemplate.exchange("http://dummy.restapiexample.com/api/v1/employee/"+id, HttpMethod.GET, entity, String.class).getBody();
		 
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(response, Employee.class);
		
		 return employee;
	}

}
