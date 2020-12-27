package flightTicketBoking;

import java.util.Scanner;
import utils.Utils;

public class FlightTicketBookingApp {
	static Scanner sc;
	static FlightTicketsList ftl = new FlightTicketsList();

	static SeatManagementSystem sms = new SeatManagementSystem();

	static void createTicket() {
		System.out.println("Enter Departure City: ");
		String departureCity = sc.nextLine();

		System.out.println("Enter Arrival City: ");
		String arrivalCity = sc.nextLine();

		while (isValidRoute(departureCity, arrivalCity)) {
			System.out.println("Enter a different destination and Arrival...");
			System.out.println("Enter Departure City: ");
			departureCity = sc.nextLine();

			System.out.println("Enter Arrival City: ");
			arrivalCity = sc.nextLine();
		}

		System.out.println("Enter Flight Number: ");
		String flightNumber = sc.nextLine();
		while (!isValidFlightNumber(flightNumber)) {
			System.out.println("Enter a valid Flight Number...");
			System.out.println("Enter Flight Number: ");
			flightNumber = sc.nextLine();
		}

		String seatNumber = generateSeatNumber();

		if (seatNumber == null)
			return;

		FlightTicket ticket = new FlightTicket(departureCity, arrivalCity, flightNumber, seatNumber);

		ftl.add(ticket);
	}

	static String generateSeatNumber() {
		System.out.println("1. Auto Generate a Seat Number.");
		System.out.println("2. Self Provide a Seat Number.");
		int option = Utils.getInputTypeInt(sc, "Enter a valid Integer...");
		while (option <= 0 && option >= 3) {
			System.out.println("1. Auto Generate a Seat Number.");
			System.out.println("1. Self Provide a Seat Number.");
			option = Utils.getInputTypeInt(sc, "Enter a valid Integer...");
		}

		String seatNumber;
		if (option == 1) {
			seatNumber = sms.bookSeat();
		} else {
			System.out.println("Enter a Seat Number: ");
			seatNumber = sc.nextLine();

			SeatBookingStatus bookingStatus = sms.bookSeatBySeatNumber(seatNumber);
			while (!bookingStatus.status) {
				System.out.println(bookingStatus.message);
				System.out.println("Enter a Seat Number: ");
				seatNumber = sc.nextLine();
				bookingStatus = sms.bookSeatBySeatNumber(seatNumber);
			}
			System.out.println(bookingStatus.message);
		}

		return seatNumber;
	}

	static FlightTicket getTicketBySeatNumber(String seatNumber) {
		FlightTicket[] ticketList = ftl.get();

		if (!sms.isValidSeatNumber(seatNumber))
			return null;

		for (int i = 0; i < ticketList.length; i++) {
			if (ticketList[i].getSeatNumber().equals(seatNumber))
				return ticketList[i];
		}

		return null;
	}

	static boolean isValidFlightNumber(String flightNumber) {
//		for length
		if (flightNumber.length() > 6 && flightNumber.length() < 3)
			return false;
//		for first two to be upper case char
		if (!Utils.isUpperCase(flightNumber.charAt(0)))
			return false;
		if (!Utils.isUpperCase(flightNumber.charAt(1)))
			return false;
//		for the rest to be digits
		for (int i = 2; i < flightNumber.length(); i++) {
			if (!Utils.isDigit(flightNumber.charAt(i)))
				return false;
		}

		return true;
	}

	static boolean isValidRoute(String departure, String arrival) {
		return Utils.toUpperCase(departure).compareTo(Utils.toUpperCase(arrival)) == 0;
	}

	static FlightTicket[] sortBySeatNumber() {
		FlightTicket[] flightTickets = ftl.get();

		for (int i = 1; i < flightTickets.length; i++) {
			int j = i - 1;

			FlightTicket key = flightTickets[i];

			int keyRow = sms.getSeatRowCol(key.getSeatNumber())[0];

			while (j >= 0 && sms.getSeatRowCol(flightTickets[j].getSeatNumber())[0] > keyRow) {
				flightTickets[j + 1] = flightTickets[j];
				j--;
			}

			flightTickets[j + 1] = key;
		}

		for (int i = 1; i < flightTickets.length; i++) {
			int j = i - 1;

			FlightTicket key = flightTickets[i];

			int keyCol = sms.getSeatRowCol(key.getSeatNumber())[1];

			int keyRow = sms.getSeatRowCol(key.getSeatNumber())[0];

			while (j >= 0 && sms.getSeatRowCol(flightTickets[j].getSeatNumber())[1] > keyCol
					&& sms.getSeatRowCol(flightTickets[j].getSeatNumber())[0] == keyRow) {
				flightTickets[j + 1] = flightTickets[j];
				j--;
			}

			flightTickets[j + 1] = key;
		}

		return flightTickets;
	}
	
	static FlightTicket[] sort() {
		FlightTicket[] flightTickets = ftl.get();
		
		FlightTicket[][] sortSpace = new FlightTicket[sms.getRows()][sms.getCols()];
		System.out.println(sms.getRows());
		System.out.println(sms.getCols());
		for (int i = 0; i < flightTickets.length; i++) {
			int row = sms.getSeatRowCol(flightTickets[i].getSeatNumber())[0];
			System.out.println(row);
			int col = sms.getSeatRowCol(flightTickets[i].getSeatNumber())[1];
			System.out.println(col);
			sortSpace[row][col] = flightTickets[i];
		}
		
		FlightTicket[] sortedTickets = new FlightTicket[ftl.size()];
		int k = 0;
		for (int i = 0; i < sortSpace.length; i++) {
			for (int j = 0; j < sortSpace[i].length; j++) {
				if(sortSpace[i][j]!=null) {
					sortedTickets[k] = sortSpace[i][j];
					k++;
				}
					
			}
			
		}

		
		
		return sortedTickets;
	}

	static void printAllTickets(FlightTicket[] ticketList) {
		for (int i = 0; i < ticketList.length; i++) {
			if (ticketList[i] != null)
				printTicket(ticketList[i]);
		}
	}

	static void printTicket(FlightTicket t) {
		System.out.println();
		System.out.println("Departure City: " + t.getDepartureCity());
		System.out.println("Arrival City: " + t.getArrivalCity());
		System.out.println("Flight No: " + t.getFlightNumber());
		System.out.println("Seat No: " + t.getSeatNumber());
	}

	static void menu() {
		System.out.println("1. Create a ticket.");
		System.out.println("2. Print Tickets.");
		System.out.println("3. Get Ticket By Seat Number: ");
		System.out.println("4. Sort Tickets By Seat Number: ");
		System.out.println("5. Show Seat Plan: ");
		System.out.println("5. Exit");
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		insertSampleData();
		int option;
		do {
			menu();
			option = Utils.getInputTypeInt(sc, "Enter a valid Integer: ");
			switch (option) {
			case 1:
				createTicket();
				break;
			case 2:
				printAllTickets(ftl.get());
				break;
			case 3:
				System.out.println("Enter a Seat Number: ");
				String seatNumber = sc.nextLine();
				while (!sms.isValidSeatNumber(seatNumber)) {
					System.out.println("Enter a valid Seat Number...");
					System.out.println("Enter a Seat Number: ");
					seatNumber = sc.nextLine();
				}

				if (getTicketBySeatNumber(seatNumber) == null)
					System.out.println("Ticket not Booked...");
				else
					printTicket(getTicketBySeatNumber(seatNumber));
				break;
			case 4:
				printAllTickets(sortBySeatNumber());
//				printAllTickets(sort());
				break;
			case 5:
				sms.showSeatPlan();
				break;
			default:
				break;
			}
		} while (option != 6);
		
	}

	static void insertSampleData() {
		ftl.add(new FlightTicket("Guwahati", "Bengaluru", "MH123", "1A"));
		ftl.add(new FlightTicket("Koklata", "Bengaluru", "MH123", "20B"));
		ftl.add(new FlightTicket("Delhi", "Bengaluru", "MH123", "4A"));
		ftl.add(new FlightTicket("Lukhnow", "Bengaluru", "MH123", "14F"));
		ftl.add(new FlightTicket("Chandigarh", "Bengaluru", "MH123", "21F"));
		ftl.add(new FlightTicket("Chennai", "Bengaluru", "MH123", "25D"));
		ftl.add(new FlightTicket("Mumbai", "Bengaluru", "MH123", "2A"));
		ftl.add(new FlightTicket("Guwahati", "Bengaluru", "MH123", "3C"));
		ftl.add(new FlightTicket("Delhi", "Bengaluru", "MH123", "5E"));
		ftl.add(new FlightTicket("Delhi", "Bengaluru", "MH123", "19B"));
		ftl.add(new FlightTicket("Mumbai", "Bengaluru", "MH123", "17D"));
		ftl.add(new FlightTicket("Delhi", "Bengaluru", "MH123", "12E"));
		ftl.add(new FlightTicket("Mumbai", "Bengaluru", "MH123", "1D"));
		ftl.add(new FlightTicket("Delhi", "Bengaluru", "MH123", "1F"));
		ftl.add(new FlightTicket("Mumbai", "Bengaluru", "MH123", "1B"));
		ftl.add(new FlightTicket("Delhi", "Bengaluru", "MH123", "1C"));
	}
}
