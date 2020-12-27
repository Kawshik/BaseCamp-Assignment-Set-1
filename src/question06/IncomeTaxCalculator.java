package question06;

import java.util.Scanner;

public class IncomeTaxCalculator {

	static float getInputTypeFloat(Scanner sc, String msg) {
		float val = 0;
		do {
			if(sc.hasNextFloat()) {
				val = sc.nextFloat();
				sc.nextLine();
				return val;
			} else {
				System.out.println(msg);
				sc.nextLine();
			}
		} while(true);
	}
	
	public static float calculateTax(float balance) {
		int rate = 0;
		if(balance<=50000) {
			rate = 0;
		} else if(balance>50000 && balance<=60000) {
			rate = 10;
		} else if(balance>60000 && balance<=150000) {
			rate = 20;
		} else {
			rate = 30;
		}
		
		return balance * (float)(rate/100.00);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float balance = getInputTypeFloat(sc, "Enter a valid Balance..,");
		System.out.println(calculateTax(balance) * 12);
	}
}
