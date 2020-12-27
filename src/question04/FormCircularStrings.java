package question04;

import java.util.Scanner;

public class FormCircularStrings {

	static int getInputTypeInt(Scanner sc, String msg) {
		int val = 0;
		do {
			if (sc.hasNextInt()) {
				val = sc.nextInt();
				sc.nextLine();
				return val;
			} else {
				System.out.println(msg);
				sc.nextLine();
			}
		} while (true);
	}
	
	static boolean contains(String[] arr, String s) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].equals(s))
					return true;
			}
		}

		return false;
	}

	static String[] formCircularStrings(String s, int size) {
		String[] circularStrings = new String[s.length()];

		for (int i = 0; i < s.length(); i++) {
			String circularString = "";
			for (int j = 0; j < size; j++) {
				if ((j + i) > s.length() - 1) {
					circularString += s.charAt(j + i - s.length());
				} else {
					circularString += s.charAt(j + i);
				}
			}
			
			if (!contains(circularStrings, circularString))
				circularStrings[i] = circularString;
		}

		return circularStrings;
	}

	static void printDistinctCircularsArray(String[] distinctCirculars) {
		for (int i = 0; i < distinctCirculars.length; i++) {
			if(distinctCirculars[i]!=null)
				System.out.println(distinctCirculars[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		String s = "aaabcd";
//		int size = 2;
		
		System.out.println("Enter a String: ");
		String s = sc.nextLine();
		
		System.out.println("Enter the length of Circular Strings: ");
		int size = getInputTypeInt(sc, "Enter a valid Length of type int");

		printDistinctCircularsArray(formCircularStrings(s, size));
		
		sc.close();
	}
}
