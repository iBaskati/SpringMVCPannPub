package validationPack;

import formErrors.FormAddOfferErrors;
import models.Offer;

public class FormAddOfferValidation extends ValidationForm {
	
	public FormAddOfferValidation() {
		super();
	}
	
	
	public FormAddOfferErrors validation(Offer offer) {
		formErrors.FormAddOfferErrors formAddOfferErrors = new FormAddOfferErrors();
		int errorsCount = 0;
		try {
			this.isAdressValid(offer.getAdress());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorAdress(e.getMessage());
			errorsCount++;
		}
		
		try {
			this.isTypeValid(offer.getType());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorType(e.getMessage());
			errorsCount++;
		}
		
		try {
			this.isHeightValid(offer.getHeight());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorHeight(e.getMessage());
			errorsCount++;
		}

		try {
			this.isWidthValid(offer.getWidth());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorWidth(e.getMessage());
			errorsCount++; 
		}
		
		try {
			this.isImageValid(offer.getImageString());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorImage(e.getMessage());
			// errorsCount++; this error will not be counted ;) trust me 
		}
		
		try {
			this.isDescriptionValid(offer.getDescription());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorDescription(e.getMessage());
			errorsCount++;
		}
		
		try {
			this.isPriceValid(offer.getPrice());
		}
		catch(Exception e) {
			formAddOfferErrors.setErrorPrice(e.getMessage());
			errorsCount++;
		}
		
		if(errorsCount==0) {
			formAddOfferErrors.setGoodForm(Boolean.TRUE);
		}
		return formAddOfferErrors;
	}



}
