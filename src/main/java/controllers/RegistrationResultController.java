package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDaoImpl;
import models.User;

@Controller
public class RegistrationResultController {
	
	
	@RequestMapping(path="/registration_result", method = RequestMethod.POST)
	public ModelAndView handleForm(@RequestParam("name") String name,@RequestParam("password") String password) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		User user=context.getBean("user",User.class);
		user.setName(name);
		user.setPassword(password);
		UserDaoImpl userDaoImpl=context.getBean("userDaoImpl",UserDaoImpl.class);   
		int result=userDaoImpl.insert(user);
		ModelAndView modelAndView=new ModelAndView();
		if(result>0)
			modelAndView.addObject("confirmation","Registration Successful");
		else
			modelAndView.addObject("confirmation","Registration Failed");
		
		modelAndView.setViewName("registration_result");
		return modelAndView;
	}
//	@RequestMapping(path="/result", method = RequestMethod.POST)
//	public String handleForm(@ModelAttribute User user, Model model) {
//		
//		System.out.println("Hi result");
//		return "result";
//	}
	
}
