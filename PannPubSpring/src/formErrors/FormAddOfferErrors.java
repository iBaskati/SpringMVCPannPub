package formErrors;


public class FormAddOfferErrors {
	private String errorId;
	private String errorAdress;
	private String errorType;
	private String errorHeight;
	private String errorWidth;
	private String errorImage;
	private String errorDescription;
	private String errorPrice;
	private boolean isGoodForm;
	
	
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	public String getErrorAdress() {
		return errorAdress;
	}
	public void setErrorAdress(String errorAdress) {
		this.errorAdress = errorAdress;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorHeight() {
		return errorHeight;
	}
	public void setErrorHeight(String errorHeight) {
		this.errorHeight = errorHeight;
	}
	public String getErrorWidth() {
		return errorWidth;
	}
	public void setErrorWidth(String errorWidth) {
		this.errorWidth = errorWidth;
	}
	public String getErrorImage() {
		return errorImage;
	}
	public void setErrorImage(String errorImage) {
		this.errorImage = errorImage;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorPrice() {
		return errorPrice;
	}
	public void setErrorPrice(String errorPrice) {
		this.errorPrice = errorPrice;
	}
	public boolean isGoodForm() {
		return isGoodForm;
	}
	public void setGoodForm(boolean isGoodForm) {
		this.isGoodForm = isGoodForm;
	}
	@Override
	public String toString() {
		return "FormAddOfferErrors [errorId=" + errorId + ", errorAdress=" + errorAdress + ", errorType=" + errorType
				+ ", errorHeight=" + errorHeight + ", errorWidth=" + errorWidth + ", errorImage=" + errorImage
				+ ", errorDescription=" + errorDescription + ", errorPrice=" + errorPrice + ", isGoodForm=" + isGoodForm
				+ "]";
	}
	
	
	
}
