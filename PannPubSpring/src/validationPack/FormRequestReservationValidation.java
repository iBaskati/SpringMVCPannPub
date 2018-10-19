package validationPack;


import javax.servlet.http.HttpServletRequest;

import formErrors.FormRequestReservationErrors;


public class FormRequestReservationValidation extends ValidationForm {

	
	
	public FormRequestReservationValidation() {
		super();
	}

	public FormRequestReservationErrors validation(HttpServletRequest request) {
		
		String dateStartString = request.getParameter("dateStart");
		String dateEndString = request.getParameter("dateEnd");
		String requestLetter = request.getParameter("requestLetter");
		FormRequestReservationErrors formRequestReservationErrors = new FormRequestReservationErrors();
		int errorsCount = 0;
		
		try{
			this.isDateValid(dateStartString);
		}
		catch(Exception e) {
			formRequestReservationErrors.setErrorDateStart(e.getMessage());
			errorsCount++;
		}
		
		
		try{
			this.isDateValid(dateEndString);
			
		}
		catch(Exception e) {
			formRequestReservationErrors.setErrorDateEnd(e.getMessage());
			errorsCount++;
		}
		
		// only if start date and end date are good ! 
		if(errorsCount==0) {
			try {
				this.isStartDateBeforeEndDate(dateStartString,dateEndString);
			}
			catch(Exception e){
				formRequestReservationErrors.setErrorDateEnd(e.getMessage());
				errorsCount++;
			}
		}
		
		
		try{
			this.isRequestLetterValid(requestLetter);
		}
		catch(Exception e) {
			formRequestReservationErrors.setErrorRequestLetter(e.getMessage());
			errorsCount++;
		}
		
		if(errorsCount ==0) {
			formRequestReservationErrors.setGoodForm(Boolean.TRUE);
		}
		else {
			formRequestReservationErrors.setGoodForm(Boolean.FALSE);
		}
		
		return formRequestReservationErrors;
	}




}
