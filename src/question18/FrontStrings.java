package question18;

import java.util.Scanner;

public class FrontStrings {

//	handles Input mismatch exception
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
	
	public static String printFrontStrings(String s,int length){
		String frontStrings = "";
		
//		Check if length of string is less than 3, then add the whole string length no of times
		if(s.length()<=3) {
			for(int i=1;i<=length;i++) {
				frontStrings+=s;
			}
		} 
//		if length of string greater than 3 add first 3 characters
		else {
			for(int i=1;i<=length;i++) {
				frontStrings+=((char)s.charAt(0));
				frontStrings+=((char)s.charAt(1));
				frontStrings+=((char)s.charAt(2));
			}
		}  
		
		return frontStrings;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		Take String Input
		System.out.println("Enter a String: ");
		String s = sc.nextLine();
		
//		Take Length Input
		System.out.println("Enter a length of Front Strings: ");
		int length = getInputTypeInt(sc, "Enter a valid length in Integer...");
		
		System.out.println(printFrontStrings(s,length));
	}
}
