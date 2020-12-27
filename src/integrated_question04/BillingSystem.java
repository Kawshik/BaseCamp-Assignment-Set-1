package integrated_question04;

import utils.Utils;

public class BillingSystem extends SuperMarketApp {

	private Bill bill;
	private ItemsList il;
	private double total;

	public void menu() {
		System.out.println("1. Enter an Item.");
		System.out.println("2. Show Total.");
		System.out.println("3. Exit.");
	}

	private void createItemsList() {
		System.out.println("Enter product Id: ");
		String id = sc.nextLine();

		System.out.println("Enter Quantity: ");
		int quantity = Utils.getInputTypeInt(sc, "Enter a valid Integer...");

		Item item = ims.getItem(id);
		if(item == null) {
			System.out.println("Invalid Item...");
			return;
		}
		for (int i = 0; i < quantity; i++)
			il.add(item);

	}

	private void calculateTotal() {
		Item[] items = il.get();
		double total = 0;
		for (int i = 0; i < items.length; i++) {
			double discount = items[i].getPrice() * (items[i].getDiscount() / 100.0);
			double pricePerItem = items[i].getPrice() - discount;
			total += pricePerItem;
		}
		this.total = total;
	}

	protected Bill generateBill() {
		il = new ItemsList();
		total = 0;
		int option;

		do {
			this.menu();
			System.out.println("Enter an Option: ");
			option = Utils.getInputTypeInt(sc, "Enter a valid Option...");

			switch (option) {
			case 1:
				createItemsList();
				break;
			case 2:
				calculateTotal();
				System.out.println("Total so far: " + this.total);
				break;
			case 3:
				this.bill = new Bill(this.il, this.total);
				break;
			default:
				System.out.println("Enter a valid Option...");
				break;
			}
		} while (option != 3);

		return this.bill;

	}

	public static void main(String[] args) {

		BillingSystem bs = new BillingSystem();
		bs.generateBill();
		System.out.println(bs.bill);

	}
}
