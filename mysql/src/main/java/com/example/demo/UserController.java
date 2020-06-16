package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<User> index(){
		Iterable<User> courseIterable = userRepo.findAll();
		ArrayList<User> userList = new ArrayList<User>();
		courseIterable.forEach(a -> userList.add(a));
		return userList;
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addCourse(@RequestBody User user)
	{

		userRepo.save(user);
		
	}
	

}
