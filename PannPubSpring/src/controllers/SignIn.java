package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import db.Db;
import models.Client;
import services.SignInService;

@Controller
public class SignIn {

	
		@RequestMapping(value = "/signIn") 
		public String signIn(HttpServletRequest request, ModelMap model) { 
			Db.testStuffThatYouCanDelete();
			HttpSession session = request.getSession();
			// helpers 
			System.out.println("From SignIn Controller .. "+session.getAttribute("client"));
			// helpers 
			if(session.getAttribute("client")==null) {
				model.addAttribute("command", new Client());
				return "signIn";
			}
			else {
				return "redirect:index";
			}
		} 
	    
		@RequestMapping(value = "/signInService") 
		public  String  signInService(@ModelAttribute("SpringWeb")Client client, ModelMap model, HttpServletRequest request) {
			HttpSession session = request.getSession();
			// helpers 
			System.out.println("From SignInService Controller .. "+session.getAttribute("client"));
			// helpers 		
			
			if(session.getAttribute("client")==null) {
				ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
				SignInService signInService = (SignInService) ctx.getBean("signInService");
				return signInService.signInFunction(client,model,request);
			}
			else {
				return "redirect:index";
			}
		} 
		
}
