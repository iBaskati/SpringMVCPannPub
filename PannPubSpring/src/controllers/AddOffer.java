package controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import models.Offer;
import services.AddOfferService;

@Controller
public class AddOffer {
	
	
	@RequestMapping(value = "/addOffer") 
	public String addOffer(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From addOffer Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			model.addAttribute("command", new Offer());
			return "addOffer";
		}
		else {
			return "redirect:index";
		}
	} 
	
	/*
	 * this service has a prb, when loading big files it drops an error that is not expected !! 
	 */
	@RequestMapping(value = "/addOfferService") 
	public  String  addOfferService(@ModelAttribute("SpringWeb")Offer offer, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From addOfferSrvice Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			AddOfferService addOfferService = (AddOfferService) ctx.getBean("addOfferService");
			return addOfferService.addOfferFunction(offer,model,request);
		}
		else {
			return "redirect:index";
		}
	} 
	
	
	
	
}
