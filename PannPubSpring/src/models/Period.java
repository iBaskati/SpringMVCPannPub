package models;

import java.util.Date;

public class Period {
	
	private Date dateStart;
	private Date dateEnd;
	
	
	public Period(Date dateStart, Date dateEnd) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
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
	
	
	
	public boolean Collapse(Period perRes) {
		if(this.dateEnd.before(perRes.dateStart)) {
			return false;
		}
		else if(this.dateStart.after(perRes.dateEnd)) {
			return false;
		}
		return true;
	}

}
