package com.example.demo;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
/*Spring @Repository annotation is used to indicate that the class provides 
 * the mechanism for storage, retrieval, search, update and delete operation on objects.
 */
public interface CourseRepo extends CrudRepository<Course, Integer>{

}
