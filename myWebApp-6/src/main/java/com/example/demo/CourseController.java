package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import antlr.collections.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseRepo courseRepo;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Course> index(){
		Iterable<Course> courseIterable = courseRepo.findAll();
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseIterable.forEach(a -> courseList.add(a));
		return courseList;
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addCourse(@RequestBody Course course)
	{
		System.out.println(course.getId());
		System.out.println(course.getName());
		System.out.println(course.getDescription());
		courseRepo.save(course);
	}
	
	@RequestMapping("/delete/{id}")
	public void deleteCourse(@PathVariable int id)
	{
		System.out.println("in spring");
		courseRepo.deleteById(id);
	}
	
	@RequestMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCourse(@RequestBody Course course)
	{
		System.out.println(course.getId());
		System.out.println(course.getName());
		System.out.println(course.getDescription());
		courseRepo.save(course);
	}
	
}
