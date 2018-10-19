package formErrors;

public class FormRequestReservationErrors {
	
	
	public FormRequestReservationErrors() {

	}


	private String errorDateStart;
	private String errorDateEnd;
	private String errorRequestLetter;
	private boolean isGoodForm;
	private String errorFreePeriod;
	
	
	public String getErrorDateStart() {
		return errorDateStart;
	}
	public void setErrorDateStart(String errorDateStart) {
		this.errorDateStart = errorDateStart;
	}
	public String getErrorDateEnd() {
		return errorDateEnd;
	}
	public void setErrorDateEnd(String errorDateEnd) {
		this.errorDateEnd = errorDateEnd;
	}
	public String getErrorRequestLetter() {
		return errorRequestLetter;
	}
	public void setErrorRequestLetter(String errorRequestLetter) {
		this.errorRequestLetter = errorRequestLetter;
	}
	
	
	public boolean isGoodForm() {
		return isGoodForm;
	}
	public void setGoodForm(boolean isGoodForm) {
		this.isGoodForm = isGoodForm;
	}
	
	
	public String getErrorFreePeriod() {
		return errorFreePeriod;
	}
	public void setErrorFreePeriod(String errorFreePeriod) {
		this.errorFreePeriod = errorFreePeriod;
	}
	@Override
	public String toString() {
		return "FormReservationValidation [errorDateStart=" + errorDateStart + ", errorDateEnd=" + errorDateEnd
				+ ", errorRequestLetter=" + errorRequestLetter + "]";
	}
	
	
	
	
}
