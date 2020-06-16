package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MyWebApp6Application {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApp6Application.class, args);
	}
	
	@Bean
	/*A bean is an object that is instantiated, assembled, 
	 * and otherwise managed by a Spring IoC container. 
	 * These beans are created with the configuration metadata that you supply to the container.
	 * The Spring container is at the core of the Spring Framework. 
	 * The container will create the objects, wire them together, configure them, 
	 * and manage their complete life cycle from creation till destruction. 
	 * The Spring container uses DI to manage the components that make up an application. 
	 * These objects are called Spring Beans
	 */
	@Autowired
	/*Bean wiring is the process of combining beans with Spring container. 
	 * The required beans are to be informed to the container and how the container should use dependency injection 
	 * to tie them together, at the time of wiring the beans.
	 * The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation, constructor, 
	 * a property or methods with arbitrary names and/or multiple arguments.
	 */
	CommandLineRunner runner(CourseRepo courseRepo) {
		return (args) -> {
			long count = courseRepo.count();
			
			if(count == 0) {
				
					Course c1 = new Course();
					c1.setName("JS");
					c1.setDescription("Form Validation");
					
					Course c2 = new Course();
					c2.setName("CSS");
					c2.setDescription("Styling webpages");
					
					Course c3 = new Course();
					c3.setName("Angular");
					c3.setDescription("Frontend");
					
					Course c4 = new Course();
					c4.setName("HTML");
					c4.setDescription("Webpage Contents");
					
					courseRepo.save(c1);
					courseRepo.save(c2);
					courseRepo.save(c3);
					courseRepo.save(c4);
				
			}
		};

	}
}
		
	


