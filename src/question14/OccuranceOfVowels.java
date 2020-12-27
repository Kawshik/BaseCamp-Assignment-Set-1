package question14;

import java.util.Scanner;

public class OccuranceOfVowels {
	static boolean isVowel(char c) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < vowels.length; i++) {
			if (c == vowels[i])
				return true;
		}

		return false;
	}
	
	static int vowelCount(String sentence) {
		int count = 0;
		for(int i=0;i<sentence.length();i++) {
			if(isVowel(sentence.charAt(i)))
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String sentence  = sc.nextLine();
		String sentence  = "Actions speak louder than words.";
		System.out.println(vowelCount(sentence));
		sc.close();
	}
}
