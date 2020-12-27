package integrated_question02;

import java.util.Scanner;

import utils.Utils;

public class MuseumApp {
	static Scanner sc;
	static VisitorsList vl;
	static Visitor[] visitors;

	public static void menu() {
		System.out.println("1. Enter 1 to Add a Visitor");
		System.out.println("2. Enter 2 to Fetch Number of Visitors per day");
		System.out.println("3. Enter 3 to Fetch Number of Visitors within a Range");
		System.out.println("4. Enter 4 to Fetch Ratio between Male and Female Visitors");
		System.out.println("5. Enter 5 to Fetch Total Earnings per day");
		System.out.println("6. Enter 6 to Exit");
	}

	static int getFeePerAge(int age) {
		if (age < 5)
			return 0;
		if (age >= 5 && age < 18)
			return 10;
		if (age >= 18 && age < 60)
			return 20;
		if (age >= 60)
			return 5;

		return 0;
	}

	static boolean isAge(int age) {
		return (age > 0 && age < 105);
	}

	public static void addVisitor() {
		System.out.println("Enter Visitors Name: ");
		String name = sc.nextLine();

		System.out.println("Enter Visitors Age: ");
		int age = Utils.getInputTypeInt(sc, "Enter a valid Age...");
		while (!isAge(age)) {
			System.out.println("Enter a Valid Visitors Age: ");
			age = Utils.getInputTypeInt(sc, "Enter a valid Age...");
		}

		System.out.println("Enter Visitors Gender: ");
		String gender = sc.nextLine();

		Visitor visitor = new Visitor(name, age, gender);
		visitor.setFee(getFeePerAge(age));

		vl.add(visitor);
	}

	public static int getVisitorsCount() {
		return vl.size();
	}

	public static int getVisitorsCountWithinRange(int lowerLimit, int upperLimit) {
		int counter = 0;
		for (int i = 0; i < vl.size(); i++) {
			if (visitors[i].getAge() >= lowerLimit && visitors[i].getAge() <= upperLimit)
				counter++;
		}

		return counter;
	}

	static float HCF(int num1, int num2) {
		int temp;
		while (num2 != 0) {
			temp = num2;
			num2 = num1 % num2;
			num1 = temp;
		}
		return num1;
	}

	public static String getMaleToFemaleRatio() {
		int maleCount = 0;
		int femaleCount = 0;

		for (int i = 0; i < vl.size(); i++) {
			if (visitors[i].getGender().equals("Male"))
				maleCount++;
			if (visitors[i].getGender().equals("Female"))
				femaleCount++;
		}

		String ratio = "";

		float HCF = HCF(maleCount, femaleCount);
		if (HCF == 1.0) {
			ratio += maleCount;
			ratio += ":";
			ratio += femaleCount;
		} else {
			ratio += (int) (maleCount / HCF);
			ratio += ":";
			ratio += (int) (femaleCount / HCF);
		}

		return ratio;
	}

	public static int getTotalEarnings() {
		int earnings = 0;
		for (int i = 0; i < vl.size(); i++) {
			earnings += visitors[i].getFee();
		}

		return earnings;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		vl = new VisitorsList();
		visitors = vl.get();

		int option;
		do {
			menu();

			System.out.println("Choose an Option");
			option = Utils.getInputTypeInt(sc, "Enter a valid Option(1 - 6)...");

			switch (option) {
			case 1:
				addVisitor();
				System.out.println();
				break;
			case 2:
				System.out.println("Todays Total Visitors are: " + getVisitorsCount());
				System.out.println();
				break;
			case 3:
				System.out.println("Enter the Lowest Age: ");
				
				int lowerLimit = Utils.getInputTypeInt(sc, "Enter a valid Age...");
				System.out.println("Enter the Highest Age: ");
				
				int upperLimit = Utils.getInputTypeInt(sc, "Enter a valid Age...");
				System.out.println(getVisitorsCountWithinRange(lowerLimit, upperLimit));
				
				System.out.println();
				break;
			case 4:
				System.out.println("The Ratio between Male and Female is: " + getMaleToFemaleRatio());
				System.out.println();
				break;
			case 5:
				System.out.println("Todays Total Earnings are: " + getTotalEarnings());
				System.out.println();
				break;
			case 6:
				System.out.println("Terminated...");
				break;
			default:
				break;
			}
		} while (option != 6);

		sc.close();
	}
}
