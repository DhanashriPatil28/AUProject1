package com.example.demo.controller;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;

import com.example.demo.service.CategoryService;
import com.example.demo.dao.CategoryRepo;

@RestController

public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	private final static Logger logger = Logger.getLogger(CategoryController.class.getName());
	
	//Get all available categories
	
	@GetMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCategories(){
		logger.info("Called Service to get available Categories");
		return new ResponseEntity<>(categoryService.GetCategories(), HttpStatus.OK);
	}
	
	//Get all available courses
	@GetMapping(path = "/categories/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCourses(){
		logger.info("Called Service to get Courses from all available Categories");
		return new ResponseEntity<>(categoryService.GetCourses(), HttpStatus.OK);
	}
	
	//Get available courses from particular category
	@GetMapping(path = "/categories/{category_name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCoursesFromCategory(@PathVariable String category_name){
		logger.info("Called Service to get Courses from selected Category");
		return new ResponseEntity<>(categoryService.GetCoursesFromCategory(category_name), HttpStatus.OK);
	}
	
	//Getting a particular course details
	@GetMapping(path = "/categories/courseDetails/{course_name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCourseDetails(@PathVariable String course_name){
		logger.info("Called Service to get details of selected Course");
		return new ResponseEntity<>(categoryService.GetCourseDetails(course_name), HttpStatus.OK);
	}
	
	//Add Course
	@PostMapping(path = "/categories/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addCourse(@RequestBody Category course)
	{
		logger.info("Called Service to add new Course");
	    return new ResponseEntity<>(categoryService.AddCourse(course), HttpStatus.CREATED);
	}
	
	//update course
	@RequestMapping(path = "/categories/update/{course_name}")
	public ResponseEntity<Object> updateCourse(@RequestBody Category course)
	{
		logger.info("Called Service to update the Course");
		categoryService.UpdateCourse(course);
	    return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}
	
	//Delete course
		@RequestMapping(path = "/categories/delete/{course_name}")
		public ResponseEntity<Object> deleteCourse(@PathVariable String course_name)
		{
			logger.info("Called Service to delete selected Course");
			categoryService.DeleteCourse(course_name);
		    return new ResponseEntity<>(HttpStatus.OK);
		}	
}
