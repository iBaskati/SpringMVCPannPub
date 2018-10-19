package services;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import db.Db;
import formErrors.FormSignUpErrors;
import models.Client;
import models.ClientView;
import validationPack.FormSignUpValidation;

public class SignUpService {
	
	
	public String SignUpFunction(ModelMap model, Client client, HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			FormSignUpValidation formSignUpValidation = (FormSignUpValidation) ctx.getBean("formSignUpValidation");
			FormSignUpErrors formSignUpErrors = formSignUpValidation.validation(client);
			if(formSignUpErrors.isGoodForm()) {
				this.addClinet(client);
				session.setAttribute("client", new ClientView(client));
				session.setMaxInactiveInterval(30*24*60*60);
				return "redirect:index";
			}
			else {
				model.addAttribute("formSignUpErrors",formSignUpErrors);
				client.setPassword(null);
				client.setPasswordConf(null);
				model.addAttribute("command",client);
				return "signUp";
			}
		}
		catch(Exception e) {
			System.out.println("Try again .. ");
	    	e.printStackTrace();
	    	return "redirect:error";
		}
	}
	
	
	
	public void addClientinDB(Client client) throws IOException {
		// code goes here ..
		Db.addClient(client);
	}

	public void addClinet(Client client) throws Exception {
		System.out.println("Starting .. "+client.toString());
		this.addClientinDB(client);
		System.out.println("Done Signing Up the client :) ");
	}
	
	
}
