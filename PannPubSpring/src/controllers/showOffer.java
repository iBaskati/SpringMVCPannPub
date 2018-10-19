package controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Offer;
import services.SearchOffersService;
import validationPack.ValidationParameter;


@Controller
public class showOffer {
	
	@RequestMapping(value = "/showOffer", method = RequestMethod.GET) 
	public String offers(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From showOffer Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			ValidationParameter validationParameter = (ValidationParameter) ctx.getBean("validationParameter");
			SearchOffersService searchOffersService = (SearchOffersService) ctx.getBean("searchOffersService");
			Long ID = validationParameter.getIDValue(request.getParameter("ID"));
			if(ID != null) {
				Offer offer = searchOffersService.getOfferWithID(ID);
				request.setAttribute("offer", offer);
				return "showOffer";
			}
			else {
				return "redirect:offersFilters";
			}
		}
		else {
			return "redirect:index";
		}
	}
	
}
