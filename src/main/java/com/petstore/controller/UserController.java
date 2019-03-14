package com.petstore.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petstore.model.User;
import com.petstore.service.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping(path="/add")
	public ResponseEntity<User> add(@RequestBody @Valid User user) {
		logger.info("add user : " + user.getUsername());
		user = userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/authenticate")
	public ResponseEntity<User> authenticate(@RequestBody @Valid User user) {
		logger.info("add user : " + user.getUsername());
		user = userService.isAuthenticatedUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(path="/logout")
	public ResponseEntity<User> logout(@RequestBody @Valid User user) {
		logger.info("logout user : " + user.getUsername());
//		user = userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
