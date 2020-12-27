package question17;

import java.util.Scanner;

public class MirrorCopy {

	static void printArray(String[] arr){
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	static String reverseString(String s){
		String reversed = "";
		for(int i = s.length()-1;i>=0;i--) {
			reversed+=s.charAt(i);
		}
		
		return reversed;
	}
	
	static String[] mirror(String[] arr) {
		String[] mirrorCopy = new String[arr.length];
		
		for(int i = arr.length -1; i>=0; i--) {
			mirrorCopy[(arr.length -1) - i] = reverseString(arr[i]);
		}
		
		return mirrorCopy;
	}
	
	static int wordCount(String sentence) {		
		int count = 0;
		int start = 0;
		int end = sentence.length();
	
		for (int i = start; i < end; i++) {
			if (sentence.charAt(i) == 32)
				count++;
		}
		return count+1;
	}
	
	static String[] convertStringToArray(String sentence){
		
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sentence = sc.nextLine();
		
		String[] strings = convertStringToArray(sentence);
		
		printArray(mirror(strings));
		
		sc.close();
	}
}
