package integrated_question04;

import java.util.Scanner;

import utils.Utils;

public class SuperMarketApp {
	protected static CustomerManagementSystem cms = new CustomerManagementSystem();
	protected static InventoryManagementSystem ims = new InventoryManagementSystem();
	protected static BillingSystem bs = new BillingSystem();
			
	protected static Scanner sc = new Scanner(System.in);

	private void startBillingSystem() {
		System.out.println("Enter Customer Phone Number: ");
		String phoneNumber = sc.nextLine();
		while(!Utils.isPhoneNumber(phoneNumber)) {
			System.out.println("Enter Correct Customer Phone Number: ");
			phoneNumber = sc.nextLine();
		}
		
		Bill bill = bs.generateBill();
		
		Customer c = cms.getOrCreateCustomerByPhoneNumber(phoneNumber);
		c.getBills().add(bill);
		c.settotalBillTillDate(c.gettotalBillTillDate() + bill.getTotalBill());
	}
	
	private void startCustomerManagementSystem() {
		int option;
		do {
			System.out.println("1. Show Most Valued Customer.");
			System.out.println("2. Exit.");
			System.out.println("Enter an option: ");
			option = Utils.getInputTypeInt(sc, "Enter a valid Integer...");

			switch (option) {
			case 1:
				System.out.println(cms.getMostValuedCustomer());
				break;
			case 2:
				break;
			default:
				break;
			}
		}while(option!=2);
	}
	
	private void startInventoryManagementSystem() {
		int option;
		do {			
			System.out.println("1. Show Most Sold Item Till Date.");
			System.out.println("2. Exit.");
			System.out.println("Enter an option: ");
			option = Utils.getInputTypeInt(sc, "Enter a valid Integer...");
			
			switch (option) {
			case 1:
				Item[] mostSold = ims.mostSoldItemTillDate().get();
				for (int i = 0; i < mostSold.length; i++) {
					System.out.println(mostSold[i].getId());
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		}while(option!=2);
		
		
		
	}
	
	public void menu(){
		System.out.println("1. Start Billing Process.");
		System.out.println("2. Show Customer Details.");
		System.out.println("3. View Inventory.");
		System.out.println("4. Exit.");
	}
	
	public static void main(String[] args) {		
		SuperMarketApp sma = new SuperMarketApp();
		
		int opt;
		do {
			sma.menu();
			opt = Utils.getInputTypeInt(sc, "Enter a valid Option(1-4)");
			
			switch (opt) {
			case 1:
				sma.startBillingSystem();
				break;
			case 2:
				sma.startCustomerManagementSystem();
				break;
			case 3:
				sma.startInventoryManagementSystem();
				break;
			case 4:
				System.out.println("Terminated...");
				break;
			default:
				System.out.println("Enter a valid option...");
				break;
			}
		}while(opt!=4);
	}
}
