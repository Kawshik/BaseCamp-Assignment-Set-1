package question10;

import java.util.Scanner;

public class UniqueCharacters {
	public static boolean isAlpha(char c) {
		return ((int) c >= 96 && (int) c <= 122) || ((int) c >= 65 && (int) c <= 91);
	}
	
	public static boolean isUpperCase(char c) {
		return ((int) c >= 65 && (int) c <= 91);
	}
	
	public static char toLowerCase(char c) {
		return (char)(c+32);
	}
	
	public static boolean hasUniUniqueCharacters(String s) {
		int[] alphabetCount = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(!isAlpha(temp)) return false;
			else {
				if(isUpperCase(temp)) {
					temp = toLowerCase(temp);
				}
				
				if(alphabetCount[(temp-'a')] == 0) alphabetCount[(temp-'a')]++;
				else return false;
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String string = sc.nextLine();
		if(hasUniUniqueCharacters(string)) System.out.println("This String has Unique Characters");
		else System.out.println("This String does not have Unique Characters");
		
		sc.close();
	}
}
