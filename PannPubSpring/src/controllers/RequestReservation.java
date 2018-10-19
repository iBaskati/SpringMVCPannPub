package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.RequestReservationService;
import validationPack.ValidationParameter;


@Controller
public class RequestReservation {
	
	
	@RequestMapping(value = "/requestReservation", method = RequestMethod.GET) 
	public String requestReservation(HttpServletRequest request, ModelMap model) { 
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From requestReservation Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			ValidationParameter validationParameter = (ValidationParameter) ctx.getBean("validationParameter");
			Long ID = validationParameter.getIDValue(request.getParameter("ID"));
			if(ID != null) {
				model.addAttribute("ID",ID);
				return "requestReservation";
			}
			else {
				return "redirect:offersFilters";
			}
		}
		else {
			return "redirect:index";
		}
	}
	
	
	@RequestMapping(value = "/requestReservationService" , method = RequestMethod.POST) 
	public  String  requestReservationService(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// helpers 
		System.out.println("From requestReservationService Controller .. "+session.getAttribute("client"));
		// helpers 
		if(session.getAttribute("client")!=null) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			RequestReservationService requestReservationService = (RequestReservationService) ctx.getBean("requestReservationService");
			ValidationParameter validationParameter = (ValidationParameter) ctx.getBean("validationParameter");
			Long ID = validationParameter.getIDValue(request.getParameter("ID"));
			if(ID != null) {
				return requestReservationService.requestReservationFunction(request,model,ID);
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
