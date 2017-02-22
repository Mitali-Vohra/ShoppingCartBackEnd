package com.niit.shoppingcart.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	@Autowired HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView showHomePage()
	{
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("msg","Welcome to Shopping Cart Application");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView showLoginPage()
	{
		System.out.println("In showLoginPage method");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("UserClickedLogin","true");
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegisterPage()
	{
		System.out.println("In showRegisterPage method");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("UserClickedRegister","true");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView showLogout()
	{
		ModelAndView mv = new ModelAndView("/home");
		session.removeAttribute("loginMessage");
		session.invalidate();
		return mv;
	}
	
	@RequestMapping("/validate")
	public ModelAndView checkForValidation(@RequestParam("userId") String id,@RequestParam("password") String pass)
	{
		ModelAndView mv = new ModelAndView("/home");
		if(id.equals("admin") && pass.equals("password"))
		{
			mv.addObject("successMessage","Valid credentials");
			session.setAttribute("loginMessage", "Welcome "+id);
			return mv;
		}
		else
		{
		mv.addObject("errorMessage","Invalid credentials!!!!Please Try Again");
		return mv;	
		}
	}

}
