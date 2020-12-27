package integrated_question09;

import java.util.Scanner;

import utils.Utils;

public class InternetProviderApp {
	PlansList plans;
	UsersList users;
	static Scanner sc;

	public InternetProviderApp() {
		plans = new PlansList();
		users = new UsersList();
	}

	void createNewPlan() {
		System.out.println("Enter the name of the plan: ");
		String name = sc.nextLine();
		System.out.println("Enter the Internet Speed: ");
		float internetSpeed = Utils.getInputTypeFloat(sc, "Enter a valid Data Type...");
		System.out.println("Enter the Download Limit: ");
		float downloadLimit = Utils.getInputTypeFloat(sc, "Enter a valid Data Type...");
		;
		System.out.println("Enter the Price of the Plan: ");
		double price = Utils.getInputTypeDouble(sc, "Enter a valid Price...");

		plans.add(new Plan(name, internetSpeed, downloadLimit, price));
	}

	void createNewUser() {
		System.out.println("Enter User Name: ");
		String name = sc.nextLine();
		System.out.println("Enter User Id: ");
		String userId = sc.nextLine();
		System.out.println("Enter User Phone Number: ");
		String phoneNumber = sc.nextLine();
		System.out.println("Enter User Address:");
		System.out.println("Enter User Street: ");
		String street = sc.nextLine();
		System.out.println("Enter User City: ");
		String city = sc.nextLine();
		System.out.println("Enter User State: ");
		String state = sc.nextLine();
		System.out.println("Enter User Country: ");
		String country = sc.nextLine();

		Plan internetPlan = selectPlan();

		this.users.add(new User(name, userId, phoneNumber, street, city, state, country, internetPlan));
	}

	Plan selectPlan() { // Used for getting a plan while creating a new User
//		Show all the plans available
		Plan[] plans = this.plans.get();
		for (int i = 0; i < plans.length; i++) {
			System.out.println("Plan " + (i + 1));
			System.out.println(plans[i]);
		}

//		take input as option
		int opt;
		do {
			System.out.println("Select a Plan (1, 2, ...)");
			opt = Utils.getInputTypeInt(sc, "Enter a valid Option (1, 2, ...)");
		} while (opt <= 0 && opt > this.plans.size());

//		return plan accordingly
		return plans[opt - 1];
	}

	void printPlans(Plan[] plans) {
		for (int i = 0; i < plans.length; i++) {
			System.out.println(plans[i]);
		}
	}

	void printUsers(User[] users) {
		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i]);
		}
	}

	User[] getUsersForPlan(Plan plan) {
		UsersList usersForPlan = new UsersList();
		User[] registeredUsers = this.users.get();
		for (int i = 0; i < registeredUsers.length; i++) {
			if (registeredUsers[i].getInternetPlan().getName().equals(plan.getName())) {
				usersForPlan.add(registeredUsers[i]);
			}
		}
		return usersForPlan.get();
	}

	void showCityNamesReverse() {
		User[] users = this.users.get();
		for (int i = 0; i < users.length; i++) {
			System.out.println(Utils.reverseString(users[i].getCity()));
		}
	}

	Plan[] sortPlansByPrice() {
		Plan[] plans = this.plans.get();

		for (int i = 1; i < plans.length; i++) {
			int j = i - 1;
			Plan key = plans[i];

			while (j >= 0 && plans[j].getPrice() > key.getPrice()) {
				plans[j + 1] = plans[j];
				j--;
			}
			plans[j + 1] = key;
		}

		return plans;
	}

	void menu() {
		System.out.println("1) Add a new plan.");
		System.out.println("2) Add a new user.");
		System.out.println("3) Display all the users.");
		System.out.println("4) Display all the plans available.");
		System.out.println("5) Display the users subscribed to a particular plan.");
		System.out.println("6) Display the city name in reverse order.");
		System.out.println("7) Sort the plans in based on ascending order of their price.");
		System.out.println("8) Exit.");
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		InternetProviderApp ipa = new InternetProviderApp();
		int opt;
		do {
			ipa.menu();
			opt = Utils.getInputTypeInt(sc, "Enter a valid Option");
			
			switch (opt) {
			case 1:
				ipa.createNewPlan();
				break;
			case 2:
				ipa.createNewUser();
				break;
			case 3:
				ipa.printUsers(ipa.users.get());
				break;
			case 4:
				ipa.printPlans(ipa.plans.get());
				break;
			case 5:
				ipa.printUsers(ipa.getUsersForPlan(ipa.selectPlan()));
				break;
			case 6:
				ipa.showCityNamesReverse();
				break;
			case 7:
				ipa.printPlans(ipa.sortPlansByPrice());
				break;
			case 8:
				System.out.println("Terminated...");
				break;

			default:
				break;
			}
		}while(opt!=8);
	}
}
