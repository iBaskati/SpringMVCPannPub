package db;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import models.Client;
import models.ClientView;
import models.Offer;
import models.ReservationRequest;

public class Db implements ServletContextListener {
	

	private static ArrayList<Client> clientsDB = new ArrayList<>();
	private static ArrayList<Offer> offersDB = new ArrayList<>();
	private static ArrayList<ReservationRequest> reservationsRequestDB = new ArrayList<>();
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
	
	
	
	

	private Db() {
		System.out.println("Number of Client in DB is  .... " + clientsDB.size());
		System.out.println("Number of Offers in DB is  .... " + offersDB.size());
	}

	public static ArrayList<Client> getClientsDB() {
		return clientsDB;
	}

	public static ArrayList<Offer> getOffersDB() {
		return offersDB;
	}

	public static void addClient(Client client) {
		clientsDB.add(client);
	}

	public static void addOffer(Offer offer) {
		offersDB.add(offer);
		System.err.println("ADDED Offer "+ offer.getId() + offer.toString());
	}
	
	public static ArrayList<ReservationRequest> getReservationsDB() {
		return reservationsRequestDB;
	}

	public static void addReservation(ReservationRequest reservation) {
		reservationsRequestDB.add(reservation);
		System.err.println("ADDED reservation "+ reservation.getId() + reservation.toString());
	}

	public static Client isClientinDB(Client client) {
		for (Client clientinDB : clientsDB) {
			// equal by email and password 
			if (clientinDB.equals(client)) {
				return clientinDB;
			}
		}
		return null;
	}

	public static boolean isClientEmailinDB(Client client) {
		for (Client clientinDB : clientsDB) {
			if (clientinDB.getEmail().equals(client.getEmail())) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Offer> getMyOffersDB(ClientView client) {
		ArrayList<Offer> myOffers = new ArrayList<>();
		for (Offer offer : offersDB) {
			// equal by ID
			if (offer.getOwnerID() == client.getId()) {
				myOffers.add(offer);
			}
		}
		return myOffers;
	}

	public static void testStuffThatYouCanDelete() {
		// TODO Auto-generated method stub
		/// just for test goals 
		Client client = new Client();
		client.setEmail("A@A.com");
		client.setPassword("A@A.com");
		client.setName("OSMAN TEST USER");
		client.setId(Long.parseLong("10"));
		clientsDB.add(client);
		
		Offer offer = new Offer();
		offer.setAdress("TATA");
		offer.setDescription("MOHAMED OSMAN PANN");
		offer.setHeight(1.1);
		offer.setImageString("imageString");
		offer.setPrice(100.1);
		offer.setType("4x3 A");
		offer.setWidth(1.1);
		offer.setCreatedDate(new Date());
		offer.setOwnerID(Long.parseLong("10"));
		offersDB.add(offer);
		
		System.out.println("Test Client and Offer are now created and added to db .. ");
		////
	}

	public static boolean offerExist(Long ID) {
		for(Offer offer : Db.getOffersDB()) {
			if(offer.getId().equals(ID)) {
				return true;
			}
		}
		return false;
	}

}
