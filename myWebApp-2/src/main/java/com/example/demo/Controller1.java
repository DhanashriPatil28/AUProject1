package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/courses")
public class Controller1 {

	@Autowired
	private CoursesRepo courseRepo;

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Courses> index(){
		Iterable<Courses> courseIterable = courseRepo.findAll();
		ArrayList<Courses> courseList = new ArrayList<Courses>();
		courseIterable.forEach(a -> courseList.add(a));
		return courseList;
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Courses addCourse(@RequestBody Courses course)
	{
		System.out.println(course.getId());
		System.out.println(course.getName());
		System.out.println(course.getDescription());
		courseRepo.save(course);
		return course;
	}
	
	@RequestMapping("/delete/{id}")
	public void deleteCourse(@PathVariable int id)
	{
		System.out.println("in spring");
		courseRepo.deleteById(id);
	}
	
	@RequestMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Courses updateCourse(@RequestBody Courses course)
	{
		System.out.println(course.getId());
		System.out.println(course.getName());
		System.out.println(course.getDescription());
		courseRepo.save(course);
		return course;
	}
}
