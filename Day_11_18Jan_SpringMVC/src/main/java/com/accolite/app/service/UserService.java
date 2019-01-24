package com.accolite.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accolite.app.dao.*;
import com.accolite.app.model.Login;
import com.accolite.app.model.User;

public class UserService 
{
	
	public void register(User user) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("user-beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		userDao.register(user);
	}

	public User validateUser(Login login) {
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("user-beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		return userDao.validateUser(login);
	}
	
	public ArrayList<User> getAllUsers()
	{
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("user-beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		return userDao.getAllUsers();
	}
	
	public User getUser(String username)
	{
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("user-beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		return userDao.getUser(username);
	}
	
	public void updateUser(User user)
	{
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("user-beans.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		userDao.updateUser(user);
	}

}
