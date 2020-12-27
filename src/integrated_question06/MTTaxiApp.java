package integrated_question06;

import java.util.Scanner;

import utils.Utils;

public class MTTaxiApp {
	
	TaxisList taxis = new TaxisList();
	static Scanner sc = new Scanner(System.in);
	User createUser() {
		System.out.println("Enter User Name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter User Age: ");
		int age = Utils.getInputTypeInt(sc, "Enter a valid Age...");
		while(!Utils.isAge(age)) {
			System.out.println("Enter a valid User Age: ");
			age = Utils.getInputTypeInt(sc, "Enter a valid Age...");
		}
		
		System.out.println("Enter User Gender: ");
		String gender = sc.nextLine();
		
		System.out.println("Enter User Phone Number: ");
		String phoneNumber = sc.nextLine();
		while(!Utils.isPhoneNumber(phoneNumber)) {
			System.out.println("Enter a valid Phone Number: ");
			phoneNumber = sc.nextLine();
		}
		
		System.out.println("Enter User Distance: ");
		double distance = Utils.getInputTypeDouble(sc, "Enter a valid Distance...");
		
		return new User(name, age, gender, phoneNumber, distance);
	}
	
	void createTaxies() {
		taxis.add(new Taxi("MH123", "John", "JOHN123", 24.0));
		taxis.add(new Taxi("MH124", "Alex", "JOHN123", 34.0));
		taxis.add(new Taxi("MH125", "Sam", "JOHN123", 25.0));
		taxis.add(new Taxi("MH126", "Jack", "JOHN123", 14.0));
		taxis.add(new Taxi("MH127", "Carl", "JOHN123", 5.0));
		taxis.add(new Taxi("MH129", "Max", "JOHN123", 29.0));
		taxis.add(new Taxi("MH130", "Jones", "JOHN123", 224.0));
		taxis.add(new Taxi("MH131", "Jane", "JOHN123", 44.0));
		taxis.add(new Taxi("MH132", "Mike", "JOHN123", 24.0));
		taxis.add(new Taxi("MH133", "Suzan", "JOHN123", 82.0));
	}
	
	Taxi getTaxiForUser(User U){
		Taxi[] taxis = this.taxis.get();
		double leastDistance = 100000000;
		Taxi nearestTaxi = null;
		for (int i = 0; i < taxis.length; i++) {
			double taxiDistance = (taxis[i].getDistance() > U.getDistance())?taxis[i].getDistance() - U.getDistance():U.getDistance() - taxis[i].getDistance();
			
			if(taxiDistance < leastDistance) {
				leastDistance = taxiDistance;
				nearestTaxi = taxis[i];
			}
		}
		
		return nearestTaxi;
	}
	
	void menu() {
		System.out.println("1. Book a Taxi.");
		System.out.println("2. Exit.");
	}
	
	public static void main(String[] args) {
		MTTaxiApp mtt = new MTTaxiApp();
		mtt.createTaxies();
		int option;
		do {
			mtt.menu();
			option = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			switch (option) {
			case 1:
				System.out.println(mtt.getTaxiForUser(mtt.createUser()));
				break;
			case 2:
				break;
			default:
				break;
			}
		}while(option!=2);
	}
}
