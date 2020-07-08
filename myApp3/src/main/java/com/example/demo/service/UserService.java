package com.example.demo.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.controller.CategoryController;
import com.example.demo.dao.*;
import com.example.demo.model.Category;
import com.example.demo.model.User;

@Component
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	private final static Logger logger = Logger.getLogger(CategoryController.class.getName());
	
	public ArrayList<User> GetUsers(){
		Iterable<User> courseIterable = userRepo.findAll();
		ArrayList<User> userList = new ArrayList<User>();
		courseIterable.forEach(a -> userList.add(a));
		logger.info("All Users are fetched successfully");
		return userList;
	}

	public User AddUser(@RequestBody User user)
	{
		userRepo.save(user);
		logger.info("New User is added successfully");
		return user;
	}

}
