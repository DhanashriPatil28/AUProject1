package ControllerTesting;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.controller.CategoryController;
import com.example.demo.dao.CategoryRepo;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CategoryControllerTesting {
	
	@InjectMocks
	CategoryService categoryService;
     
    @Mock
    CategoryRepo catRepo;
    
    private MockMvc mockMvc;
    
    @Test
    void testGetCategories() {
    	Category c = new Category();
    	c.setCategoryName("Development");
    	c.setCourseName("Web Development");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	
    	Category c1 = new Category();
    	c1.setCategoryName("IT and Software");
    	c1.setCourseName("Java");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
    	
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	courses.add(c1);
    	
    	when(catRepo.findAll()).thenReturn(courses);
    	
    	Set<String> s = categoryService.GetCategories();
    	int l = s.size();
    	
    	assertEquals(l,2);
    	
    	Iterator iterator = s.iterator();
    	int j=0;
    	while(iterator.hasNext()){
    		//System.out.println(iterator.next());
    	if(j==0) {
    		assertEquals("Development",iterator.next());
    		j++;
    	}
    	else {
    		assertEquals("IT and Software",iterator.next());
    	}
    	
    	}
    }
    
    
    @Test
    void testGetCourses() {
    	Category c = new Category();
    	c.setCategoryName("IT and Software");
    	c.setCourseName("Java");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	
    	Category c1 = new Category();
    	c1.setCategoryName("Development");
    	c1.setCourseName("Web Development");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
    	
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	courses.add(c1);
    	
    	when(catRepo.findAll()).thenReturn(courses);
    	
    	Set<String> s = categoryService.GetCourses();
    	int l = s.size();
    	
    	assertEquals(l,2);
    	
    	Iterator iterator = s.iterator();
    	int j=0;
    	while(iterator.hasNext()){
    		if(j==0) {
        		assertEquals("Java",iterator.next());
        		j++;
        	}
    		else {
    			assertEquals("Web Development",iterator.next());
    		}
    	
    	}
    }
    
    @Test
    void testGetCoursesFromCategory() {
    	Category c = new Category();
    	c.setCategoryName("Development");
    	c.setCourseName("Web Development");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	
    	Category c1 = new Category();
    	c1.setCategoryName("IT and Software");
    	c1.setCourseName("Java");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
    	
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	courses.add(c1);
    	
    	when(catRepo.findAll()).thenReturn(courses);
    	
    	Set<String> s = categoryService.GetCoursesFromCategory("Development");
    	int l = s.size();
    	
    	assertEquals(l,1);
    	
    	Iterator iterator = s.iterator();
    	int j=0;
    	while(iterator.hasNext()){
    		if(j==0) {
        		assertEquals("Web Development",iterator.next());
        		j++;
        	}
    		
    	}
    }
    
    @Test
    void testGetCourseDetails() {
    	Category c = new Category();
    	c.setCategoryName("Development");
    	c.setCourseName("Web Development");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	
    	Category c1 = new Category();
    	c1.setCategoryName("IT and Software");
    	c1.setCourseName("Java");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
    	
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	courses.add(c1);
    	
    	when(catRepo.findAll()).thenReturn(courses);
    	
    	ArrayList<Category> s = categoryService.GetCourseDetails("Web Development");
    	int l = s.size();
    	
    	assertEquals(l,1);
    	
    	Iterator iterator = s.iterator();
    	int j=0;
    	while(iterator.hasNext()){
    		if(j==0) {
        		assertEquals(c,iterator.next());
        		j++;
        	}
    		
    	}
    }
    	
    @Test
    void testAddCourse() {
    	Category c = new Category();
    	c.setCategoryName("Development");
    	c.setCourseName("Web Development");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	
    	Category c1 = new Category();
    	c1.setCategoryName("IT and Software");
    	c1.setCourseName("Java");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
    	
    	Category s = categoryService.AddCourse(c1);
    	
    	assertNotNull(s);
    	assertEquals(s,c1);
    }	
    
    @Test
    void testDeleteCourse() {
    	Category c = new Category();
    	c.setCategoryName("IT and Software");
    	c.setCourseName("Java");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	Category c1 = new Category();
    	c1.setCategoryName("Development");
    	c1.setCourseName("Web Development");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
 
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	courses.add(c1);
    	
    	when(catRepo.findAll()).thenReturn(courses);
    	
    	categoryService.DeleteCourse("Java");
    	Set<String> s = categoryService.GetCourses();
    	int l = s.size();
    	
    	assertEquals(l,1);
    }

    
    @Test
    void testUpdateCourse() {
    	Category c = new Category();
    	c.setCategoryName("Development");
    	c.setCourseName("WebDevelopment");
    	c.setCourseContents("dd");
    	c.setCourseDescription("ff");
    	c.setCourseRequirements("gg");
    	c.setId(111);
    	
    	Category c1 = new Category();
    	c1.setCategoryName("IT and Software");
    	c1.setCourseName("Java");
    	c1.setCourseContents("ee");
    	c1.setCourseDescription("yy");
    	c1.setCourseRequirements("ii");
    	c1.setId(567);
    	
    	ArrayList<Category> courses = new ArrayList<Category>();
    	courses.add(c);
    	courses.add(c1);
    	
    	Category c2 = new Category();
    	c2.setCategoryName("IT and Software");
    	c2.setCourseName("Java");
    	c2.setCourseContents("eooooooooooooe");
    	c2.setCourseDescription("yinnjnnnny");
    	c2.setCourseRequirements("iipppppppppppp");
    	c2.setId(500);
    	
    	categoryService.UpdateCourse(c2);
    	
    	when(catRepo.findAll()).thenReturn(courses);
    	
    	Set<String> s = categoryService.GetCourses();
    	int l = s.size();
    	
    	assertEquals(l,2);
    	
    	ArrayList<Category> ss = categoryService.GetCourseDetails("Java");
    	//int l1 = ss.size();
    	assertEquals(ss,c2);
    }
}
