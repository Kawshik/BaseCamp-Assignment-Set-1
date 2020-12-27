package integrated_question05;

import java.util.Scanner;

import utils.Utils;

public class TravelAgentApp {
	static TicketBookingSystem tbs = new TicketBookingSystem();
	static TravellerManagementSystem tms = new TravellerManagementSystem();
	static Scanner sc = new Scanner(System.in);
	

	public void startTicketBooking(){
		Traveller traveller =  tms.getOrCreateTraveller();
		
		System.out.println("1. Book One-Way Ticket.");
		System.out.println("2. Book Return Ticket.");
		System.out.println("Enter an Option: ");
		int opt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
		switch (opt) {
		case 1:
			Ticket t = tbs.createOneWayTicket();
			traveller.getTickets().add(t);
			break;
		case 2:
			Ticket[] tickets = tbs.createReturnTicket();
			traveller.getTickets().add(tickets[0]);
			traveller.getTickets().add(tickets[1]);
			break;
		default:
			break;
		}
	}
	
	public void showTravellersDetail() {
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();
		
		Traveller t = tms.searchTraveller(name, phoneNumber);
		System.out.println("Most Preferred Destination: " + tms.mostPreferredDestination(t));
	}
	
	public void menu() {
		System.out.println("1. Start Ticket Booking.");
		System.out.println("2. Show Travellers Details.");
		System.out.println("3. Exit.");
	}
	
	public static void main(String[] args) {
		
		TravelAgentApp taa = new TravelAgentApp();
		
		int opt;
		do {
			taa.menu();
			opt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			switch (opt) {
			case 1:
				taa.startTicketBooking();
				break;
			case 2:
				taa.showTravellersDetail();
				break;
			case 3:
				System.out.println("Terminated...");
				break;
			default:
				break;
			}
		} while(opt!=3);
	}
}
