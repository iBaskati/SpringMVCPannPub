package formErrors;

public class FormSignUpErrors {
	private String errorName;
	private String errorResponsable;
	private String errorType;
	private String errorEmail;
	private String errorPassword;
	private boolean goodForm;
	
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getErrorResponsable() {
		return errorResponsable;
	}
	public void setErrorResponsable(String errorResponsable) {
		this.errorResponsable = errorResponsable;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
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
	
	@Override
	public String toString() {
		return "FormSignUpErrors [errorName=" + errorName + ", errorResponsable=" + errorResponsable + ", errorType="
				+ errorType + ", errorEmail=" + errorEmail + ", errorPassword=" + errorPassword + "]";
	}
	
	
}
