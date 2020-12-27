package question25;

import java.util.Scanner;

public class EmailValidation {
	
	static boolean isDigit(char c) {
		return ((int) c >= 48 && (int) c <= 57);
	}

	static boolean isUpperCase(char c) {
		return ((int) c >= 65 && (int) c <= 91);
	}
	
	static boolean isLowerCase(char c) {
		return ((int) c >= 96 && (int) c <= 122);
	}
	
	static boolean isEmail(String email) {
		int atCount = 0;
		for(int i = 0;i<email.length();i++) {
			if(email.charAt(i) == '@')
				atCount++;
		}
		
		if(atCount!=1) return false;
		
		String[] subStrings = splitByToken(email,'@');
		if(subStrings[0] != null && isDomain(subStrings[1])) return true;
		else return false;
	}
	
	static boolean isDomain(String d) {
		String[] subStrings = splitByToken(d,'.');
		
		if(subStrings[0] != null && subStrings[1] != null) return true;
		else return false;
	}
	
	static String[] splitByToken(String s, char token) {
		String[] subStrings = new String[2];
		String temp = "";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == token) {
				subStrings[0] = temp;
				temp = "";
			} else {
				temp+=s.charAt(i);
			}
		}
		subStrings[1] = temp;
		return subStrings;
	}
	
	static String[] calculateCharacterWeightage(String s){
		String[] weightages = new String[3];
		
		String[] subStrings = splitByToken(s, '@');
		
		int totalLength = subStrings[0].length() + subStrings[1].length();
		int lowerCaseCount = 0;
		int upperCaseCount = 0;
		int digitCount = 0;
		
		for(int i=0;i<subStrings.length;i++) {
			String temp = subStrings[i];
			for (int j = 0; j < temp.length(); j++) {
				if(isUpperCase(temp.charAt(j))) upperCaseCount++;
				if(isLowerCase(temp.charAt(j))) lowerCaseCount++;
				if(isDigit(temp.charAt(j))) digitCount++;
			}
		}
		
		weightages[0] = ((upperCaseCount*100.00)/totalLength) + "";
		weightages[1] = ((lowerCaseCount*100.00)/totalLength) + "";
		weightages[2] = ((digitCount*100.00)/totalLength) + "";
		return weightages;
 	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an Email: ");
		String email = sc.nextLine();
//		"aBd13@Xy3z.in"
		if(!isEmail(email)) {
			System.out.println("Please Enter a valid Email...");
		} else {
			String[] weightages = calculateCharacterWeightage(email);
			System.out.println("Percentage of UPPERCASE letters: "+weightages[0] +"%");
			System.out.println("Percentage of lowercase letters: "+weightages[1] +"%");
			System.out.println("Percentage of Digits: "+weightages[2] +"%");
		}
		
		sc.close();
	}
}
