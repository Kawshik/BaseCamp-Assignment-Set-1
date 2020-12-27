package integrated_question08;

import java.util.Scanner;

import utils.Utils;

public class BikeShowroomApp {
	BikesList bikes;
	static Scanner sc;
	
	public BikeShowroomApp() {
		this.bikes = new BikesList();
	}

	void menu() {
		System.out.println("1. Add Bikes.");
		System.out.println("2. Display the bikes sorted by Make.");
		System.out.println("3. Display the bikes sorted by first Type and then Make.");
		System.out.println("4. Display the least and most expensive bikes in the store.");
		System.out.println("5. Exit");
	}
	
	void addBikes(){
		System.out.println("Enter Bike Make: ");
		String make = sc.nextLine();
		System.out.println("Enter Bike Model: ");
		String model = sc.nextLine();
		System.out.println("Enter Bike Type:  (Standard, Street, Sport, Touring, Sport Touring, Cruiser)");
		String type = sc.nextLine();
		System.out.println("Enter Bike Engine CC: ");
		String engine = sc.nextLine();
		System.out.println("Enter Bike Price: ");
		double price = Utils.getInputTypeDouble(sc, "Enter a valid Price...");
		
		Bike bike = new Bike(make, model, type, engine, price);
		this.bikes.add(bike);
	}
	
	Bike[] sortByMake() {
		Bike[] bikes = this.bikes.get();
		
		for (int i = 1; i < bikes.length; i++) {
			int j = i-1;
			Bike key = bikes[i];
			
			while(j>=0 && bikes[j].getMake().compareTo(key.getMake()) > 0) {
				bikes[j+1] = bikes[j];
				j--;
			}
			bikes[j+1] = key;
		}
		
		return bikes;
	}
	
	Bike[] sortByTypeAndMake() {
		Bike[] bikes = this.bikes.get();
		
		for (int i = 1; i < bikes.length; i++) {
			int j = i-1;
			Bike key = bikes[i];
			
			while(j>=0 && bikes[j].getType().compareTo(key.getType()) > 0) {
				bikes[j+1] = bikes[j];
				j--;
			}
			bikes[j+1] = key;
		}
		
		for (int i = 1; i < bikes.length; i++) {
			int j = i-1;
			Bike key = bikes[i];
			
			while(j>=0 && bikes[j].getMake().compareTo(key.getMake()) > 0  && bikes[j].getType().equals(key.getType())) {
				bikes[j+1] = bikes[j];
				j--;
			}
			bikes[j+1] = key;
		}
		
		return bikes;
	}
	
	Bike getLeastExpensiveBike() {
		Bike[] bikes = this.bikes.get();
		double comparator = 10000000;
		Bike leastExpensive = null;
		for (int i = 0; i < bikes.length; i++) {
			if(bikes[i].getPrice()<comparator) {
				comparator = bikes[i].getPrice();
				leastExpensive = bikes[i];
			}
		}
		return leastExpensive;
	}
	
	Bike getMostExpensiveBike() {
		Bike[] bikes = this.bikes.get();
		double comparator = 0;
		Bike mostExpensive = null;
		for (int i = 0; i < bikes.length; i++) {
			if(bikes[i].getPrice()>comparator) {
				comparator = bikes[i].getPrice();
				mostExpensive = bikes[i];
			}
		}
		return mostExpensive;
	}
	
	boolean isValidBikeType(String bikeType){
		String[] bikeTypes = {"Standard", "Street", "Sport", "Touring", "Cruiser"};
		
		for (int i = 0; i < bikeTypes.length; i++) {
			if(!bikeTypes[i].equals(bikeType))
				return false;
		}
		
		return true;
	}
	
	void printBikes(Bike[] bikes){
		for (int i = 0; i < bikes.length; i++) {
			System.out.println(bikes[i]);
		}
	}
	
	public static void main(String[] args) {
		BikeShowroomApp bsa = new BikeShowroomApp();
		sc = new Scanner(System.in);
		int opt;
		do {
			bsa.menu();
			opt = Utils.getInputTypeInt(sc, "Enter a valid Option...");
			
			switch (opt) {
			case 1:
//				bsa.addBikes();
				bsa.addSampleData();
				break;
			case 2:
				bsa.printBikes(bsa.sortByMake());
				break;
			case 3:
				bsa.printBikes(bsa.sortByTypeAndMake());
				break;
			case 4:
				System.out.println("Most Expensive Bike " + bsa.getMostExpensiveBike());
				System.out.println("Least Expensive Bike " + bsa.getLeastExpensiveBike());
				break;
			case 5:
				System.out.println("Terminated...");
				break;
			default:
				break;
			}
		}while(opt!=5);
	}
	
	void addSampleData() {
		this.bikes.add(new Bike("Royal Enfield", "Classic 350", "Touring", "346", 161553));
		this.bikes.add(new Bike("Royal Enfield", "Bullet 350", "Cruiser", "346", 126982));
		this.bikes.add(new Bike("Bajaj", "Pulsar 125", "Standard", "124.4", 161553));
		this.bikes.add(new Bike("Ktm", "390 Duke", "Sport", "390", 257513));
		this.bikes.add(new Bike("Bmw", "G 310 R", "Sport", "313", 245000));
		this.bikes.add(new Bike("TVS", "Apache RR310", "Sport", "312.2", 247992));
		this.bikes.add(new Bike("Bajaj", "Pulsar NS200", "Sport", "350", 130945));
		this.bikes.add(new Bike("Tvs", "Apache RTR 180", "Standard", "177.4", 107302));
	}
}
