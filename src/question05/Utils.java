package question05;

import java.util.Scanner;

public class Utils {
//	handles Input mismatch exception
	public int getInputTypeInt(Scanner sc, String msg) {
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
	
	public char getInputTypeChar(Scanner sc, String msg) {
		do {
			String s = sc.nextLine();
			if(s.equals("")) {
				System.out.println(msg);
			} else {
				return s.charAt(0);
			}
		} while(true);
	}
	
	public String[] generateAllPossibleStrings(char[][] matrix, int size) {
		String[] allStrings = new String[size];
		int k = 0;
		for(int i = 0;i<matrix[0].length;i++) {
			String row = "";
			for (int j = 0; j < matrix.length; j++) {
				row+=matrix[i][j];
			}
			allStrings[k] = row;
			k++;
		}
		
		for(int i = 0;i<matrix[0].length;i++) {
			String col = "";
			for (int j = 0; j < matrix.length; j++) {
				col+=matrix[j][i];
			}
			allStrings[k] = col;
			k++;
		}
		
		String leftDia = "";
		String rightDia = "";
		for(int i = 0;i<matrix.length;i++) {
			leftDia += matrix[i][i];
			rightDia += matrix[i][(matrix[i].length-1) - i];
		}
		allStrings[k] = leftDia;
		k++;
		allStrings[k] = rightDia;
		k++;
		
		return allStrings;
	}
	
	public void printWordsArray(String[] words){
		for(int i=0;i<words.length;i++) {
			System.out.println(words[i]);
		}
	}
	
	public boolean isSubString(String baseString, String subString){
		String temp = "";
		for(int i = 0;i<baseString.length();i++) {
			if(baseString.charAt(i) == subString.charAt(0)) {
				int start = i;
				int end = i+subString.length()-1;
				if(end >= baseString.length()) {
					end = baseString.length() -1;
				}
				
				for(int j = start;j<=end;j++) {
					temp+=baseString.charAt(j);
				}
				
				if(temp.equals(subString))
					return true;
			}
		}
		
		return false;
	}
	
	public void printMatrix(char[][] matrix) {
		for(int i = 0;i<matrix[0].length;i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");					
			}
			System.out.println();
		}
	}
	
	public char[][] createSquareMatrix(Scanner sc, int size){
		
		char[][] matrix = new char[size][size];
		
		for(int i = 0;i<matrix[0].length;i++) {
			System.out.println("Enter the values for Row " + (i+1));
			for (int j = 0; j < matrix.length; j++) {
				System.out.println("Enter the value for Column " + (j+1));
				matrix[i][j] = getInputTypeChar(sc, "Enter a valid Character...");					
			}
		}
		
		return matrix;
	}
}
