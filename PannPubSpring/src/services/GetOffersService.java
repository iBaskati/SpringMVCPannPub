package services;

import java.util.ArrayList;
import java.util.Collections;

import db.Db;
import models.ClientView;
import models.Offer;

public class GetOffersService {

	public ArrayList<Offer> getAllOffers() {
		return this.sort(Db.getOffersDB());
	}

	private ArrayList<Offer> sort(ArrayList<Offer> offersDB) {
		Collections.sort(offersDB);
		return offersDB;
	}

	public ArrayList<Offer> getMyOffers(ClientView client) {
		return this.sort(Db.getMyOffersDB(client));
	}
}
