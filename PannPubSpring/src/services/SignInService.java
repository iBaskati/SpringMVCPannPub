package services;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import db.Db;
import formErrors.FormSignInErrors;
import models.Client;
import models.ClientView;
import validationPack.FormSignInValidation;

public class SignInService {
	
	
	
	public String signInFunction(Client client, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			FormSignInValidation formSignInValidation = (FormSignInValidation) ctx.getBean("formSignInValidation");
			FormSignInErrors formSignInErrors = formSignInValidation.validation(client);
			if(formSignInErrors.isGoodForm()) {
				Client resultClient = this.searchMatchClientinDB(client);
				if(resultClient != null) {
					client.setId(resultClient.getId());
					session.setAttribute("client", new ClientView(resultClient));
					session.setMaxInactiveInterval(30*24*60*60);
					return "redirect:index";
				}
				else {
					formSignInErrors.setErrorInvalidData("Invalid Email or Password !");
					model.addAttribute("formSignInErrors",formSignInErrors);
					client.setPassword(null);
					model.addAttribute("command",client);
					return "signIn";
				}
			}
			else {
				model.addAttribute("formSignInErrors",formSignInErrors);
				client.setPassword(null);
				model.addAttribute("command",client);
				return "signIn";
			}
		}
		catch(Exception e) {
			System.out.println("Try again .. ");
	    	e.printStackTrace();
	    	return "redirect:error";
		}
	}
	
	
	public Client searchMatchClientinDB(Client client) throws Exception {
		return Db.isClientinDB(client);
	}
	
	
	
	
	
	
	
}
