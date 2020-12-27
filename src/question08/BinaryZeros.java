package question08;

import java.util.Scanner;

public class BinaryZeros {
	
	public static int getInputTypeInt(Scanner sc, String msg) {
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
	
	static String decimalToBinary(int num) {
		String revBinary = "";
		while (num > 0) {
			revBinary += ((num % 2) + "");
			num = num / 2;
		}

		String binary = "";
		for (int i = revBinary.length() - 1; i >= 0; i--) {
			binary+=revBinary.charAt(i);
		}

		return binary;
	}

	static int countZeros(String binary) {
		int count = 0;
		for (int i = 0; i < binary.length(); i++) {
			if(binary.charAt(i) == '0')
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Decimal Number");
		int num = getInputTypeInt(sc, "Enter a valid Number...");
		System.out.println("Total Zeros: ");
		System.out.println(countZeros(decimalToBinary(num)));
		sc.close();
	}
}
