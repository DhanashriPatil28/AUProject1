package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Category;

public interface CategoryRepo extends CrudRepository<Category,Integer>{

}
