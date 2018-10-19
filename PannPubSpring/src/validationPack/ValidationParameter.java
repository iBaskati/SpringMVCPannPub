package validationPack;

public class ValidationParameter {
	
	
	public ValidationParameter() {
	}

	public Double getPriceValue(String priceString) {
		if(priceString == null) {
			return null;
		}
		try {
			Double price = Double.parseDouble(priceString);
			return price;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	public Long getIDValue(String IDString) {
		if(IDString == null) {
			return null;
		}
		try {
			Long price = Long.parseLong(IDString);
			return price;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
}
