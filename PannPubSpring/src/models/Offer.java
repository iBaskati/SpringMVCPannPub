package models;

import java.util.ArrayList;
import java.util.Date;

public class Offer implements Comparable<Offer>{
	private Long id;
	private String adress;
	private String type;
	private Double height;
	private Double width;
	private String stringHeight;
	private Double stringWidth;
	private String imageString;
	private String description;
	private Double price;
	private String stringPrice;
	private Date createdDate;
	// private ClientView owner;
	private Long ownerID;
	private ArrayList<Period> reservedPeriods = new ArrayList<Period>();
	
	
	
	public Offer() {
		this.generateID();
	}
	
	private void generateID() {
		this.id = (Long) (long) (Math.random()*100000);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}
	
//	public ClientView getOwner() {
//		return owner;
//	}
//	public void setOwner(ClientView owner) {
//		this.owner = owner;
//	}
	
	public String getStringHeight() {
		return stringHeight;
	}

	public void setStringHeight(String stringHeight) {
		this.stringHeight = stringHeight;
	}

	public double getStringWidth() {
		return stringWidth;
	}

	public void setStringWidth(double stringWidth) {
		this.stringWidth = stringWidth;
	}

	public String getStringPrice() {
		return stringPrice;
	}

	public void setStringPrice(String stringPrice) {
		this.stringPrice = stringPrice;
	}

	
	
	public ArrayList<Period> getReservedPeriods() {
		return reservedPeriods;
	}

	public void setReservedPeriods(ArrayList<Period> reservedPeriods) {
		this.reservedPeriods = reservedPeriods;
	}

	

	@Override
	public String toString() {
		return "Offer [id=" + id + ", adress=" + adress + ", type=" + type + ", height=" + height + ", width=" + width
				+ ", imageString=" + imageString + ", description=" + description + ", price=" + price
				+ ", createdDate=" + createdDate + ", ownerID=" + ownerID + "]";
	}

	@Override
	public int compareTo(Offer offer) {
		if( this.getCreatedDate().after(offer.getCreatedDate())) {
			return -1;
		}
		else if( this.getCreatedDate().before(offer.getCreatedDate())) {
			return 1;
		}
		else return 0;
	}

	public Long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}
	
	
	
}
