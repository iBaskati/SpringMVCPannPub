package services;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import db.Db;
import formErrors.FormAddOfferErrors;
import models.ClientView;
import models.Offer;
import validationPack.FileOperatAndValidat;
import validationPack.FormAddOfferValidation;

public class AddOfferService {

	public String addOfferFunction(Offer offer, ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			
			ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			FormAddOfferValidation formAddOfferValidation = (FormAddOfferValidation) ctx.getBean("formAddOfferValidation");
			// image validation is not WELL processed in this line of code !! 
			FormAddOfferErrors formAddOfferErrors = formAddOfferValidation.validation(offer);
			// Now image ( with name = "imageString" )  validation will start
			boolean ImageIsOK = FileOperatAndValidat.validateImage(request, "imageString", formAddOfferErrors, offer);
			if(formAddOfferErrors.isGoodForm() && ImageIsOK) {
				offer.setCreatedDate(new Date());
				ClientView ownerClient = (ClientView) session.getAttribute("client");
				//offer.setOwner(ownerClient);
				offer.setOwnerID(ownerClient.getId());
				this.addOffer(offer,request,formAddOfferErrors);
				return "redirect:index";
			}
			else {
				model.addAttribute("formAddOfferErrors",formAddOfferErrors);
				model.addAttribute("command",offer);
				return "addOffer";
			}
			
		}
		catch(Exception e) {
			System.out.println("Try again .. ");
	    	e.printStackTrace();
	    	return "redirect:error";
		}
	}

	private void addOffer(Offer offer, HttpServletRequest request, FormAddOfferErrors formAddOfferErrors) throws IOException, ServletException {
		SaveFileService.saveFile("imageString" , offer ,request , formAddOfferErrors);
		Db.addOffer(offer);
	}

}
