package controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import models.ClientView;
import models.Offer;
import services.GetOffersService;


@Controller
public class GetOffers {
	
	
	@RequestMapping(value = "/offers") 
	public String offers(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From offers Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			GetOffersService getOffersService = (GetOffersService) ctx.getBean("getOffersService");
			ArrayList<Offer> offers = getOffersService.getAllOffers(); 
			request.setAttribute("offers", offers);
			return "offers";
		}
		else {
			return "redirect:index";
		}
	}
	
	
	
	@RequestMapping(value = "/myOffers") 
	public String myOffers(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From myOffers Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			GetOffersService getOffersService = (GetOffersService) ctx.getBean("getOffersService");
			ArrayList<Offer> myOffers = getOffersService.getMyOffers((ClientView) session.getAttribute("client")); 
			request.setAttribute("myOffers", myOffers);
			return "myOffers";
		}
		else {
			return "redirect:index";
		}
	}
	
}
