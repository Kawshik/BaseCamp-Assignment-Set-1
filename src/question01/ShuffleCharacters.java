package question01;

import java.util.Scanner;

public class ShuffleCharacters {

	static boolean isChar(char c) {
		return ((int) c >= 96 && (int) c <= 122) || ((int) c >= 65 && (int) c <= 91);
	}

	static boolean isUpperCaseChar(char c) {
		return ((int) c >= 65 && (int) c <= 91);
	}
	
	static boolean isLowerCaseChar(char c) {
		return ((int) c >= 96 && (int) c <= 122);
	}
	
	static char toLowerCase(char c) {
		return (isUpperCaseChar(c))?(char)(c+32):c;
	}
	
	static char toUpperCase(char c) {
		return (isLowerCaseChar(c))?(char)(c-32):c;
	}
	
	static String shuffleCharacters(String string) {
		String shuffledString = "";
		
		int i = 0, j = string.length()-1;
		
		while(i<=j) {
			if(i==j) {
				shuffledString += (isChar(string.charAt(i)))?toLowerCase(string.charAt(i)):string.charAt(i);
			} else {
				shuffledString += (isChar(string.charAt(i)))?toLowerCase(string.charAt(i)):string.charAt(i);
				shuffledString += (isChar(string.charAt(j)))?toUpperCase(string.charAt(j)):string.charAt(j);
			}
			
			i++;
			j--;
		}
		
		return shuffledString;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		Take user Input
		System.out.println("Enter a String: ");
		String inputString = sc.nextLine();
		
//		Print Result
		System.out.println("Shuffled String: " + shuffleCharacters(inputString));
		
		sc.close();
	}
}
