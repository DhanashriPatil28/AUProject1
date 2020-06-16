package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;

@RunWith(SpringRunner.class)
@DataJpaTest
class MyWebApp2ApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	

    @Resource
    private CoursesRepo courseRepo;
	
	@Test
	public void testSaveCourse() {
		
		Courses course = getCourse();
		courseRepo.save(course);
		Courses course1 = courseRepo.findById(3).orElse(new Courses());
		
		assertThat(course).isEqualTo(course1);
	}
	
	private Courses getCourse() {
		Courses course = new Courses();
		course.setCourseId(3);
		course.setCourseName("Python");
		course.setCourseDescription("Used in AI, ML");
		return course;
		
	}
}
