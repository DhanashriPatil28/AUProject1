package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.dao.CategoryRepo;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepo catRepo;
	
	//Get all available categories
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<String> getCategories(){
		Iterable<Category> courseIterable = catRepo.findAll();
		Set<String> categories = new HashSet<String>();
		courseIterable.forEach(a -> categories.add(a.getCategoryName()));
		return categories;
	}
	
	//Get all courses from all available categories
	@GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<String> getCourses(){
		Iterable<Category> courseIterable = catRepo.findAll();
		Set<String> categories = new HashSet<String>();
		courseIterable.forEach(a -> categories.add(a.getCourseName()));
		return categories;
	}
	
	//Get all courses from particular category
	@GetMapping(path = "/{category_name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<String> getCoursesFromCategory(@PathVariable String category_name){
		
		Iterable<Category> courseIterable = catRepo.findAll();
		ArrayList<Category> courseList = new ArrayList<Category>();
		courseIterable.forEach(a -> courseList.add(a));
		
		Predicate<Category> condition = c -> !(c.getCategoryName().startsWith(category_name));
		courseList.removeIf(condition);
		
		Set<String> categories = new HashSet<String>();
		Iterator i = courseList.iterator();
	      
		Category c = new Category();
		
	    while (i.hasNext()) {
	    	c = (Category) i.next();
	    	String name = c.getCourseName();
	    	categories.add(name);
	    }
	    
		return categories;
	
	}
	
	//Getting a particular course details
	@GetMapping(path = "/courseDetails/{course_name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Category> getCourseDetails(@PathVariable String course_name){
		System.out.println(course_name);
		Iterable<Category> courseIterable = catRepo.findAll();
		ArrayList<Category> courseList = new ArrayList<Category>();
		courseIterable.forEach(a -> courseList.add(a));
		
		Predicate<Category> condition = c -> !(c.getCourseName().startsWith(course_name));
		courseList.removeIf(condition);
		
		return courseList;
	
	}
	
	//Add Course
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Category addCourse(@RequestBody Category course)
	{
		catRepo.save(course);
		return course;
	}
	
	//Delete course
	@RequestMapping(path = "/delete/{course_name}")
	public void deleteCourse(@PathVariable String course_name)
	{
		Iterable<Category> courseIterable = catRepo.findAll();
		ArrayList<Category> courseList = new ArrayList<Category>();
		courseIterable.forEach(a -> courseList.add(a));
		
		Iterator i = courseList.iterator();
		Category c = new Category();
	
	    while (i.hasNext()) {
	    	
	    	c = (Category) i.next();
	    	String name = c.getCourseName();
	  
	    	if(name.equals(course_name)) {
	    		int id = c.getId();
	    		catRepo.deleteById(id);
	    	}
		    	
		}
		
	}	
	
	//Update course
		@RequestMapping(path = "/update/{course_name}")
		public void updateCourse(@RequestBody Category course)
		{
			Iterable<Category> courseIterable = catRepo.findAll();
			ArrayList<Category> courseList = new ArrayList<Category>();
			courseIterable.forEach(a -> courseList.add(a));
			
			Iterator i = courseList.iterator();
			Category c = new Category();
			
		    while (i.hasNext()) {
		    	
		    	c = (Category) i.next();
		    	
		    	String name = c.getCourseName();
		    	
		    	if(name.equals(course.getCourseName())) {
		    		int id = c.getId();
		    		catRepo.deleteById(id);
		    		catRepo.save(course);
		    	}
			    	
			}
			
		}	
	
}
