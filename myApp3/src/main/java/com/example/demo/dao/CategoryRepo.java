package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
	
	public static final CategoryRepo catRepo1 = null;
	
	public default void addCourse(Category c) {
		catRepo1.save(c);
	}

}
