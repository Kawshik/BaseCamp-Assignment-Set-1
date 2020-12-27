package question09;

import java.util.Scanner;

public class SmallestMultipleOfOnes {
	
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
	
	public static long getSmallestMultiple(int num) {
		long count = 2;
		long rem = 11 % num;
		while (rem != 0) {
			rem = (rem * 10 + 1) % num;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number (should not be a multiple of 2 or 5): ");
		int num = getInputTypeInt(sc, "Enter a valid Integer");
		
		if(num>0 && num<=10000 && num%2!=0 && num%5!=0) {
			System.out.println(getSmallestMultiple(num));
		} else {
			System.out.println("Not Possible");
		}
	}
}
