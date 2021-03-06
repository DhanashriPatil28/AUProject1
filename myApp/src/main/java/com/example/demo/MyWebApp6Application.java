package com.example.demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.CategoryController;


@SpringBootApplication
public class MyWebApp6Application {

	public static void main(String[] args) {
		final Logger l = Logger.getLogger(MyWebApp6Application.class.getName());
		l.info("this is a info message");
		
		SpringApplication.run(MyWebApp6Application.class, args);
		System.out.println("Running...");
	}
	

	/*A bean is an object that is instantiated, assembled, 
	 * and otherwise managed by a Spring IoC container. 
	 * These beans are created with the configuration metadata that you supply to the container.
	 * The Spring container is at the core of the Spring Framework. 
	 * The container will create the objects, wire them together, configure them, 
	 * and manage their complete life cycle from creation till destruction. 
	 * The Spring container uses DI to manage the components that make up an application. 
	 * These objects are called Spring Beans
	 */

	/*Bean wiring is the process of combining beans with Spring container. 
	 * The required beans are to be informed to the container and how the container should use dependency injection 
	 * to tie them together, at the time of wiring the beans.
	 * The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation, constructor, 
	 * a property or methods with arbitrary names and/or multiple arguments.
	 */
	

	}

		
	


