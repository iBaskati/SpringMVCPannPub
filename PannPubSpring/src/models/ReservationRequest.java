package models;

import java.util.Date;

public class ReservationRequest {
	
	private Long id;
	private Date dateStart;
	private Date dateEnd;
	private String requestLetter;
	private Long IDOffer;
	
	
	
	public ReservationRequest(Date dateStart, Date dateEnd, String requestLetter, Long IDOffer) {
		this.generateID();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.requestLetter = requestLetter;
		this.IDOffer = IDOffer;
	}


	public ReservationRequest() {
		this.generateID();
	}
	
	private void generateID() {
		this.id = (long) (Math.random()*100000);
	}
	
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getRequestLetter() {
		return requestLetter;
	}
	public void setRequestLetter(String requestLetter) {
		this.requestLetter = requestLetter;
	}
	public Long getIDOffer() {
		return IDOffer;
	}


	public void setIDOffer(Long iDOffer) {
		IDOffer = iDOffer;
	}


	@Override
	public String toString() {
		return "Reservation [dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", requestLetter=" + requestLetter
				+ "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
