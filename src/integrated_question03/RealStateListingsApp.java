package integrated_question03;

import java.util.Scanner;

import utils.Utils;

public class RealStateListingsApp {
	
	static Scanner sc;
	static HouseList hl;
	
	public static void menu() {
		System.out.println();
		System.out.println("1. Create a Listing.");
		System.out.println("2. Filter through Listings.");
		System.out.println("3. Exit.");
	}
	
	public static void createListing(){
		
		
//		Get house type
		String type = "";
		
		int typeOpt;
		do {
			System.out.println("Select a type option...");
			System.out.println("1. Apartment Flat");
			System.out.println("2. Individual House");
			typeOpt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			if(typeOpt<=0 && typeOpt>=3) System.out.println("Enter a valid Type Option...");
		}while(typeOpt<=0 && typeOpt>=3);
		
		if(typeOpt == 1) type += "Apartment Flat";
		else type += "Individual House";
		
		
//		Get house rooms
		String rooms = "";
		
		int roomOpt;
		do {
			System.out.println("Select a room option...");
			System.out.println("1. 1BHK");
			System.out.println("2. 2BHK");
			System.out.println("3. 3BHK");
			roomOpt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			if(roomOpt<=0 && roomOpt>=4) System.out.println("Enter a valid Type Option...");
		}while(roomOpt<=0 && roomOpt>=4);
		
		if(roomOpt == 1) rooms += "1BKH";
		if(roomOpt == 2) rooms += "2BHK";
		if(roomOpt == 3) rooms += "3BHK";
		
//		Get house status
		String status = "";
		
		int statusOpt;
		do {
			System.out.println("Select a status option...");
			System.out.println("1. To Let");
			System.out.println("2. For Sale");
			statusOpt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			if(statusOpt<=0 && statusOpt>=3) System.out.println("Enter a valid Type Option...");
		}while(statusOpt<=0 && statusOpt>=3);
		
		if(statusOpt == 1) status += "Rent";
		if(statusOpt == 2) status += "Sale";
		
		House house = new House(type,rooms,status);
//		house.setType(type);
//		house.setRooms(rooms);
//		house.setStatus(status);
		
		hl.add(house);
	}

	static void filterListings() {
		
//		Get house rooms
		String rooms = "";
		
		int roomOpt;
		do {
			System.out.println("Select a room option...");
			System.out.println("1. 1BHK");
			System.out.println("2. 2BHK");
			System.out.println("3. 3BHK");
			roomOpt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			if(roomOpt<=0 && roomOpt>=4) System.out.println("Enter a valid Type Option...");
		}while(roomOpt<=0 && roomOpt>=4);
		
		if(roomOpt == 1) rooms = "1BKH";
		if(roomOpt == 2) rooms = "2BHK";
		if(roomOpt == 3) rooms = "3BHK";
		
//		Get house status
		String status = "";
		
		int statusOpt;
		do {
			System.out.println("Select a status option...");
			System.out.println("1. To Let");
			System.out.println("2. For Sale");
			statusOpt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			if(statusOpt<=0 && statusOpt>=3) System.out.println("Enter a valid Type Option...");
		}while(statusOpt<=0 && statusOpt>=3);
		
		if(statusOpt == 1) status = "Rent";
		if(statusOpt == 2) status = "Sale";
		
		printHouseListings(getFilteredListings(rooms, status));
	}
	
	public static House[] getFilteredListings(String rooms, String status) {
		HouseList filteredHouses = new HouseList();
		House[] houses = hl.get();
		
		for (int i = 0; i < houses.length; i++) {
			if(houses[i].getRooms().equals(rooms) && houses[i].getStatus().equals(status)) {
				filteredHouses.add(houses[i]);
			}
		}
		
		return filteredHouses.get();
	}
	
	static void printHouseListings(House[] houses) {
		for (int i = 0; i < houses.length; i++) {
			System.out.println(houses[i]);
		}
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		hl = new HouseList();
		int option;
		
		do {
			menu();
			
			option = Utils.getInputTypeInt(sc, "Enter a valid Options...");
			
			switch (option) {
			case 1:
				createListing();
				printHouseListings(hl.get());
				break;
			case 2:
				filterListings();
				break;
			case 3:
				System.out.println("Terminated...");
				break;
			default:
				System.out.println("Enter a valid Option...");
				break;
			}
		} while(option!=3);
	}
}
