package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import models.Client;
import services.SignUpService;

@Controller
public class SignUp {
	
		@RequestMapping(value = "/signUp") 
		public String signUp(HttpServletRequest request, ModelMap model) {
			HttpSession session = request.getSession();
			// helpers 
			System.out.println("From SignUp Controller .. "+session.getAttribute("client"));
			// helpers 
			if(session.getAttribute("client")==null) {
				model.addAttribute("command", new Client());
				return "signUp";
			}
			else {
				return "redirect:index";
			}
		} 
	    
		@RequestMapping(value = "/signUpService") 
		public  String  signUpService(@ModelAttribute("SpringWeb")Client client, ModelMap model, HttpServletRequest request) { 
			HttpSession session = request.getSession();
			// helpers 
			System.out.println("From SignUpClient Controller .. "+session.getAttribute("client"));
			// helpers 
			if(session.getAttribute("client")==null) {
				ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
				SignUpService signUpService = (SignUpService) ctx.getBean("signUpService");
				return signUpService.SignUpFunction(model, client, request);
			}
			else {
				return "redirect:index";
			}
			
		} 
		
}
