package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class Controller1 {

	@Autowired
	CoursesRepo repo;
	
	@Autowired
	UserRepo repo1;
	
	@RequestMapping("login")
	public String login()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user)
	{
		System.out.println("in user add");
		repo1.save(user);
		return "home.jsp";
	}
	
	@RequestMapping("home")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/goToAdd")
	public String goToAdd()
	{
		return "adding.jsp";
	}
	
	@RequestMapping("/addCourse")
	public String addCourse(Courses course)
	{
		repo.save(course);
		return "home.jsp";
	}
	
	@RequestMapping("/showingParticular")
	public String showingParticular()
	{
		return "showingParticular.jsp";
	}
	
	@RequestMapping("/getCourse")
	public ModelAndView getCourse(@RequestParam int courseId)
	{
		ModelAndView mv = new ModelAndView("showCourse.jsp");
		Courses course = repo.findById(courseId).orElse(new Courses());
		mv.addObject("course", course);
		return mv;
	}
	
	@RequestMapping("/goToDelete")
	public String goToDelete()
	{
		return "deleting.jsp";
	}
	
	@RequestMapping("/deleteCourse")
	public String deleteCourse(int courseId)
	{
		repo.deleteById(courseId);
		return "home.jsp";
	}
	
	@RequestMapping("/updatingCourse")
	public String updatingCourse()
	{
		return "updating.jsp";
	}
	
	@RequestMapping("/updateCourse")
	public String updateCourse(Courses course)
	{
		repo.save(course);
		return "home.jsp";
	}
}
