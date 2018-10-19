package validationPack;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationForm {
	
	public ValidationForm() {
		
	}
	
	protected boolean isDateValid(String dateString) throws Exception  {
		if (!this.isStringEmpty(dateString)) {
			try{
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				df.parse(dateString);
				return true;
			}
			catch(Exception e) {
				throw new Exception ("Date format is not valid !");
			}
		} 
		else {
			throw new Exception ("Choose a Date !");
		}
	}
	
	protected boolean isStartDateBeforeEndDate(String dateStartString, String dateEndString) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateStart = df.parse(dateStartString);
		Date dateEnd = df.parse(dateEndString);
		System.out.println("date Start :" + dateStart.toString() +" "+ dateStartString);
		System.out.println("date End :" + dateEnd.toString() +" "+ dateEndString );
		if(dateStart.before(dateEnd)) {
			return true;
		}
		else {
			throw new Exception("The start of a period should be before the end of the same period ! :D ");
		}
	}
	
	
	protected boolean isRequestLetterValid(String requestLetter) throws Exception {
		if (!this.isStringEmpty(requestLetter)) {
			return true;
		}
		throw new Exception ("Please write a request letter !");
	}
	
	
	protected boolean isPasswordValid(String password, String passwordConf) throws Exception {
		// TODO Auto-generated method stub
		if(password.equals(passwordConf)) {
			if (!this.isStringEmpty(password)) {
				if(password.length()<6) {
					throw new Exception("Password should be at least 6 characters !");
				}
				else {
					return true;
				}
			}
			else {
				throw new Exception ("Don't you need a password !!");
			}
		}
		else {
			throw new Exception("Password and confirmation don't match !");
		}
	}


	protected boolean isEmailValid(String email) throws Exception {
		if (!this.isStringEmpty(email)) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception ("Email is Invalid");
			}
		} 
		else {
			throw new Exception ("Put your Email !");
		}
		return true;
	}
	
	
	protected boolean isAdressValid(String adress) throws Exception {
		if (!this.isStringEmpty(adress)) {
			return true;
		}
		throw new Exception ("Put Adress !");
	}
	
	protected boolean isTypeValid(String type) throws Exception {
		if (!this.isStringEmpty(type)) {
			return true;
		}
		throw new Exception ("Put Type !");
	}
	
	protected boolean isDescriptionValid(String description) throws Exception {
		if (!this.isStringEmpty(description)) {
			return true;
		}
		throw new Exception ("Put Description !");
	}
	
	protected boolean isImageValid(String image) throws Exception {
		if (!this.isStringEmpty(image)) {
			return true;
		}
		throw new Exception ("Put Image !");
	}
	
	protected boolean isPriceValid(double price) throws Exception {
		return isDoubleValid(price);
	}
	
	protected boolean isHeightValid(double height) throws Exception {
		return isDoubleValid(height);
	}
	
	protected boolean isWidthValid(double width) throws Exception {
		return isDoubleValid(width);
	}
	
	protected boolean isItDouble(String s) throws Exception {
		try {
			Double.parseDouble(s);
		}
		catch(Exception e) {
			throw new Exception ("Number is not Valid");
		}
		return true;
	}
	
	protected boolean isDoubleValid(double d) throws Exception {
		if ( d != 0) {
			return true;
		}
		throw new Exception ("0 is not valid !");
	}
	
	protected boolean isStringEmpty(String s) {
		if ( s != null && s.trim().length() != 0 ) {
			return false;
		}
		return true;
	}
	
}
