package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import db.Db;
import formErrors.FormRequestReservationErrors;
import models.Offer;
import models.Period;
import models.ReservationRequest;
import validationPack.FormRequestReservationValidation;


public class RequestReservationService {

	public String requestReservationFunction(HttpServletRequest request, ModelMap model, Long ID) {
		try {
			
			String dateStartString = request.getParameter("dateStart");
			String dateEndString = request.getParameter("dateEnd");
			String requestLetter = request.getParameter("requestLetter");
			
			
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			FormRequestReservationValidation formRequestReservationValidation = (FormRequestReservationValidation) ctx.getBean("formRequestReservationValidation");
			FormRequestReservationErrors formRequestReservationErrors = formRequestReservationValidation.validation(request);
			
			
			if(formRequestReservationErrors.isGoodForm() && Db.offerExist(ID)) {
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					Date dateStart =  df.parse(dateStartString);
					Date dateEnd = df.parse(dateEndString);
					ReservationRequest reservationsRequest = new ReservationRequest(dateStart, dateEnd, requestLetter, ID);
					boolean isFreePeriod = this.isFreePeriod(reservationsRequest);
					if(isFreePeriod) {
						this.makeReservation(reservationsRequest);
						System.err.println("Good .. reservation is done, now go to index ");
						return "redirect:index";
					}
					else {
						formRequestReservationErrors.setErrorFreePeriod("this period is not totaly free !");
						model.addAttribute("formRequestReservationErrors",formRequestReservationErrors);
						model.addAttribute("dateStart", dateStartString);
						model.addAttribute("dateEnd", dateEndString);
						model.addAttribute("requestLetter", requestLetter);
						model.addAttribute("ID",ID);
						return "requestReservation";
					}
				} catch (ParseException e) {
					return "redirect:error";
				}
			}
			else {
				model.addAttribute("formRequestReservationErrors",formRequestReservationErrors);
				model.addAttribute("dateStart", dateStartString);
				model.addAttribute("dateEnd", dateEndString);
				model.addAttribute("requestLetter", requestLetter);
				model.addAttribute("ID",ID);
				return "requestReservation";
			}
		}
		catch(Exception e) {
			System.out.println("Try again .. ");
	    	e.printStackTrace();
	    	return "redirect:error";
		}
	}

	private void makeReservation(ReservationRequest reservationsRequest) {
		Db.addReservation(reservationsRequest);
	}

	private boolean isFreePeriod(ReservationRequest reservationsRequest) {
		Period period = new models.Period(reservationsRequest.getDateStart(), reservationsRequest.getDateEnd());
		for(Offer offer : Db.getOffersDB()) {
			if(offer.getId().equals(reservationsRequest.getIDOffer())) {
				return this.isFreePeriodFunction(offer,period);
			}
		}
		return false;
	}

	private boolean isFreePeriodFunction(Offer offer, Period period) {
		for(Period perRes : offer.getReservedPeriods()) {
			if(period.Collapse(perRes)) {
				return false;
			}
		}
		return true;
	}

	
	

}
