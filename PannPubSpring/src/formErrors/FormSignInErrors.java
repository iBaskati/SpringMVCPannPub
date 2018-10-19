package formErrors;

public class FormSignInErrors {
	private String errorEmail;
	private String errorPassword;
	private String errorInvalidData;
	private boolean goodForm;
	
	public String getErrorEmail() {
		return errorEmail;
	}
	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}
	public String getErrorPassword() {
		return errorPassword;
	}
	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}
	
	
	public boolean isGoodForm() {
		return goodForm;
	}
	public void setGoodForm(boolean goodForm) {
		this.goodForm = goodForm;
	}
	
	
	public String getErrorInvalidData() {
		return errorInvalidData;
	}
	public void setErrorInvalidData(String errorInvalidData) {
		this.errorInvalidData = errorInvalidData;
	}
	
	@Override
	public String toString() {
		return "FormSignInErrors [errorEmail=" + errorEmail + "]";
	}
	
	
}
