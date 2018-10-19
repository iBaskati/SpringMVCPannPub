package validationPack;

import formErrors.FormSignInErrors;
import models.Client;

public class FormSignInValidation extends ValidationForm {

	public FormSignInErrors validation(Client client) {
		// TODO Auto-generated method stub
		FormSignInErrors formSignInErrors = new FormSignInErrors();
		int errorsNumbers = 0;
		try {
			this.isEmailValid(client.getEmail());
		}
		catch(Exception e){
			formSignInErrors.setErrorEmail(e.getMessage());
			errorsNumbers++;
		}
		if(client.getPassword() == null || client.getPassword().trim().length() == 0 ) {
			formSignInErrors.setErrorPassword("Don't you think you need a password !");
			errorsNumbers++;
		}
		if(errorsNumbers==0) {
			formSignInErrors.setGoodForm(Boolean.TRUE);
		}
		
		return formSignInErrors;
	}

}
