package validationPack;

import db.Db;
import formErrors.FormSignUpErrors;
import models.Client;
public class FormSignUpValidation extends ValidationForm{
	
	public FormSignUpValidation() {
		super();
	}

	public FormSignUpErrors validation(Client client) {
		// TODO Auto-generated method stub
		FormSignUpErrors formSignUpErrors = new FormSignUpErrors();
		int errorsNumbers = 0;
		
		try{
			this.isEmailValid(client.getEmail());
		}
		catch(Exception e) {
			formSignUpErrors.setErrorEmail(e.getMessage());
			errorsNumbers++;
		}
		
		if(this.isEamilAlreadyInDB(client)) {
			formSignUpErrors.setErrorEmail("Email already used !");
			errorsNumbers++;
		}
		
		try{
			this.isPasswordValid(client.getPassword(),client.getPasswordConf());
		}
		catch(Exception e) {
			formSignUpErrors.setErrorPassword(e.getMessage());
			errorsNumbers++;
		}
		
		if(errorsNumbers==0) {
			formSignUpErrors.setGoodForm(Boolean.TRUE);
		}
		return formSignUpErrors;
	}
	
	
	
	public boolean isEamilAlreadyInDB(Client client) {
		return Db.isClientEmailinDB(client);
	}
	
	
	
	
}
