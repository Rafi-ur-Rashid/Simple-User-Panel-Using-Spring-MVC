package controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDaoImpl;
import models.User;

@Controller
public class UserListController {
	
	@RequestMapping(path="/userlist", method = RequestMethod.POST)
	public ModelAndView handleForm() {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		UserDaoImpl userDaoImpl=context.getBean("userDaoImpl",UserDaoImpl.class);   
		List<User> users=userDaoImpl.selectAll();
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("users",users);
		
		modelAndView.setViewName("userlist");
		return modelAndView;
	}
}
