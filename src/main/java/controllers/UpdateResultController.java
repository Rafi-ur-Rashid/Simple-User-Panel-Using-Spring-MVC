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
public class UpdateResultController {
	
	
	@RequestMapping(path="/update_result", method = RequestMethod.POST)
	public ModelAndView handleForm(@RequestParam("old_name") String oldname,@RequestParam("new_name") String newname) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		User user1=context.getBean("user",User.class);
		User user2=context.getBean("user",User.class);
		user1.setName(oldname);
		user2.setName(newname);
		UserDaoImpl userDaoImpl=context.getBean("userDaoImpl",UserDaoImpl.class);   
		int result=userDaoImpl.update(user1, user2);
		ModelAndView modelAndView=new ModelAndView();
		if(result>0)
			modelAndView.addObject("confirmation","Update Successful");
		else
			modelAndView.addObject("confirmation","Update Failed");
		
		modelAndView.setViewName("update_result");
		return modelAndView;
	}
//	@RequestMapping(path="/result", method = RequestMethod.POST)
//	public String handleForm(@ModelAttribute User user, Model model) {
//		
//		System.out.println("Hi result");
//		return "result";
//	}
	
}
