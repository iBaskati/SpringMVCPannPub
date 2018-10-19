package services;

import java.util.ArrayList;
import java.util.Collections;

import db.Db;
import models.Offer;

public class SearchOffersService {

	public ArrayList<Offer> getOffersBy(String type, Double price) {
		if(type != null) {
			if(price != null) {
				ArrayList<Offer> offers = new ArrayList<>();
				for (Offer offer : Db.getOffersDB()) {
					if(offer.getPrice() <= price && offer.getType().equals(type)) {
						offers.add(offer);
					}
				}
				Collections.sort(offers);
				return offers;
			}
			else {
				return getOffersByType(type);
			}
		}
		else {
			if(price != null) {
				return getOffersByPrice(price);
			}
			else {
				return new ArrayList<Offer>(); // no offer 
			}
		}
	}

	private ArrayList<Offer> getOffersByPrice(Double price) {
		ArrayList<Offer> offers = new ArrayList<>();
		for (Offer offer : Db.getOffersDB()) {
			if(offer.getPrice() <= price) {
				offers.add(offer);
			}
		}
		Collections.sort(offers);
		return offers;
	}

	private ArrayList<Offer> getOffersByType(String type) {
		ArrayList<Offer> offers = new ArrayList<>();
		for (Offer offer : Db.getOffersDB()) {
			if(offer.getType().equals(type)) {
				offers.add(offer);
			}
		}
		Collections.sort(offers);
		return offers;
	}

	public Offer getOfferWithID(Long ID) {
		System.out.println(Db.getOffersDB());
		for(Offer offer : Db.getOffersDB()) {
			if(offer.getId().equals(ID)) {
				return offer;
			}
		}
		return null;
	}


}
