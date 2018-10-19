package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class SearchOffer {
	
	
	@RequestMapping(value = "/offersFilters") 
	public String offersFilters(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From offersFilters Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			return "offersFilters";
		}
		else {
			return "redirect:index";
		}
	} 
	
	@RequestMapping(value = "/offersFiltersService" , method = RequestMethod.GET) 
	public HttpServletResponse offersFiltersService(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From offersFiltersService Controller .. "+session.getAttribute("client"));
		// helpers 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("client")!=null) {
			String type = request.getParameter("type");
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			SearchOffersService searchOffersService = (SearchOffersService) ctx.getBean("searchOffersService");
			ValidationParameter validationParameter = (ValidationParameter) ctx.getBean("validationParameter");
			
			Double price = validationParameter.getPriceValue(request.getParameter("price"));
			ArrayList<Offer> offersFiltred = searchOffersService.getOffersBy(type,price);
			if(offersFiltred.isEmpty()) {
				out.println("No Offer found !");
			}
			else {	
				for(Offer offer : offersFiltred) {
					out.println("<span> <h4>  "+offer.toString()+" </h4> <a href='showOffer?ID="+offer.getId()+"'> Show more </a> </span> <br/>");
				}
			}
		}
		else {
			out.println("Sign In to get this information !!");
		}
		out.close();
		return response;
	}
	
	
}
