package com.example.demo.controller;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.*;

@RestController

public class UserController1 {
	
	@Autowired
	UserService userService;
	
	private final static Logger logger = Logger.getLogger(CategoryController.class.getName());
	
	@GetMapping(path = "/categories/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUsers(){
		logger.info("Service is called to get all Users");
		return new ResponseEntity<>(userService.GetUsers(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/categories/users/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addUser(@RequestBody User user)
	{
		logger.info("Service is called to add new User");
		return new ResponseEntity<>(userService.AddUser(user), HttpStatus.CREATED);
		
	}
	

}
