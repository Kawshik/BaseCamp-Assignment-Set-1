package question02;

import java.util.Scanner;

public class WordCount {

	static void menu() {
		System.out.println("1) Type 1 to enter a sentence.");
		System.out.println("2) Type 2 to get the count of words in the sentence.");
		System.out.println("3) Type 3 to get the count of number of vowels in the sentence.");
		System.out.println("4) Type 4 to get the array of words from the sentence.");
		System.out.println("5) Type 5 to Exit.");
	}

	static boolean isChar(char c) {
		return ((int) c >= 96 && (int) c <= 122) || ((int) c >= 65 && (int) c <= 91);
	}
	
	static boolean isVowel(char c) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < vowels.length; i++) {
			if (c == vowels[i])
				return true;
		}

		return false;
	}

	static String trim(String string) {
		int start = 0;
		int end = string.length() - 1;
		
		while(!isChar(string.charAt(start))) start++;
		while(!isChar(string.charAt(end))) end--;
		
		String trimmedString = "";
		
		for(int i=start;i<=end;i++)
			trimmedString+=string.charAt(i);
		
		return trimmedString;
	}
	
//	handles Input mismatch exception
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

	static int wordCount(String sentence) {		
		int count = 0;
	
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == 32)
				count++;
		}
		return count+1;
	}

	static int vowelCount(String sentence) {
		int count = 0;
		for(int i=0;i<sentence.length();i++) {
			if(isVowel(sentence.charAt(i)))
				count++;
		}
		
		return count;
	}

	static String[] getArrayOfWords(String sentence){
		
		String[] words = new String[wordCount(sentence)];
		int i = 0;
		
		String word = "";
		
		for(int j = 0;j<sentence.length();j++) {
			if (sentence.charAt(j) == 32) {
				words[i] = word;
				word = "";
				i++;
			} else {
				word+=sentence.charAt(j);
			}
		}
		
		words[i] = word;
		
		return words;
	}
	
	static void printWordsArray(String[] words){
		for(int i=0;i<words.length;i++) {
			System.out.println(words[i]);
		}
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		String sentence = "";

		int option;

		do {
			menu();
			option = getInputTypeInt(sc, "Enter a Valid Option...");
			switch (option) {
			case 1:
				System.out.println("Enter a String: ");
				sentence = trim(sc.nextLine());
				break;
			case 2:
				System.out.println("Word Count: " + wordCount(sentence));
				break;
			case 3:
				System.out.println("Vowel Count: " + vowelCount(sentence));
				break;
			case 4:
				String[] words = getArrayOfWords(sentence);
				printWordsArray(words);
				break;
			case 5:
				break;
			default:
				System.out.println("Enter a valid option...");
			}
		} while (option != 5);

		sc.close();
	}
}
