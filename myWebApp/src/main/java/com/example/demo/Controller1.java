package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class Controller1 {

	@RequestMapping("/")
	public String login()
	{
		System.out.println("hiii");
		return "login.jsp";
	}
	@RequestMapping("home")
	public String home()
	{
		System.out.println("on home");
		return "home.jsp";
	}
}
