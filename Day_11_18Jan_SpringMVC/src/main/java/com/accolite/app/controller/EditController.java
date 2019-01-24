package com.accolite.app.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.app.model.Login;
import com.accolite.app.model.User;
import com.accolite.app.service.UserService;

@Controller
public class EditController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("userlist");
		ArrayList<User> users = userService.getAllUsers();
		mav.addObject("users", users);
		return mav;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("editUser");
		
		String username = (String) request.getServletContext().getAttribute("username");
		User user = userService.getUser(username);
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value = "/editProcess", method = RequestMethod.POST)
	public ModelAndView editProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("welcome to Accolite");
		userService.updateUser(user);
		mav.addObject("username", user.getUsername());
		return mav;
	}
	
}
