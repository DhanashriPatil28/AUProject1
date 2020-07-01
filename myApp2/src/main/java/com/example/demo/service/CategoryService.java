package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.CategoryController;
import com.example.demo.dao.CategoryRepo;
import com.example.demo.model.Category;

@Component
public class CategoryService {

	@Autowired
	private CategoryRepo catRepo;
	
	private final static Logger logger = Logger.getLogger(CategoryController.class.getName());
	
	public Set<String> GetCategories(){
		Iterable<Category> courseIterable = catRepo.findAll();
		Set<String> categories = new HashSet<String>();
		courseIterable.forEach(a -> categories.add(a.getCategoryName()));
		logger.info("All Categories are fetched successfully");
		return categories;
	}
	
	public Set<String> GetCourses(){
		Iterable<Category> courseIterable = catRepo.findAll();
		Set<String> categories = new HashSet<String>();
		courseIterable.forEach(a -> categories.add(a.getCourseName()));
		logger.info("All Courses from all Categories are fetched successfully");
		return categories;
	}
	
	public Set<String> GetCoursesFromCategory(@PathVariable String category_name){
		
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
	    logger.info("All Courses from selected Category are fetched successfully");
		return categories;
	}
	
	public ArrayList<Category> GetCourseDetails(@PathVariable String course_name){
		System.out.println(course_name);
		Iterable<Category> courseIterable = catRepo.findAll();
		ArrayList<Category> courseList = new ArrayList<Category>();
		courseIterable.forEach(a -> courseList.add(a));
		
		Predicate<Category> condition = c -> !(c.getCourseName().startsWith(course_name));
		courseList.removeIf(condition);
		logger.info("Selected Course Deetails are fetched successfully");
		return courseList;
	
	}
	
	
		public Category AddCourse(@RequestBody Category course)
		{
			catRepo.save(course);
			logger.info("New Course is added successfully");
			return course;
		}
		
		
		public void UpdateCourse(@RequestBody Category course)
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
		    logger.info("The Course is updated successfully");
			
		}
		
		
		public void DeleteCourse(@PathVariable String course_name)
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
		    		logger.info("The Course is deleted successfully");
		    	}
			    	
			}
			
		}	
	
	
}
