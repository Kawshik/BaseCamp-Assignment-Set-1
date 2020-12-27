package question05;

import java.util.Scanner;

public class StringSquareMatrix {
	
	static Utils u;

	public static void menu(){
		System.out.println("1) Give an option to get the dimensions for a square matrix.");
		System.out.println("2) Fill in the Matrix.");
		System.out.println("3) Search a String in the Matrix.");
		System.out.println("4) Exit");
	}
	
	static boolean isStringPresent(char[][] matrix,String string) {
		String[] allStrings = u.generateAllPossibleStrings(matrix, matrix.length * 2 + 2);
		for(int i = 0;i<allStrings.length;i++) {
			if(u.isSubString(allStrings[i], string))
				return true;
		}	
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		u = new Utils();
//		char[][] matrix = { { 'I', 'G', 'E', 'F' }, { 'F', 'S', 'A', 'M' }, { 'A', 'B', 'C', 'D' },
//				{ 'F', 'O', 'U', 'R' } };
//		String string = "SAM";

		int size = 0;
		char[][] matrix = null;
		
		int option = 0;
		do {
			menu();
			option = u.getInputTypeInt(sc, "Enter a valid Integer Option...");
			
			switch (option) {
			case 1:
//				Get the size of the Matrix
				System.out.println("Enter the size of the square matrix: ");
				size = u.getInputTypeInt(sc, "Enter a valid Number...");
				while (size < 0) {
					System.out.println("Enter a valid Size: ");
					size = u.getInputTypeInt(sc, "Enter a valid size...");
				}
				break;
			case 2:
//				Check if the size is 0
				if(size == 0) System.out.println("Please enter a size first"); 
//				Create the matrix
				else matrix = u.createSquareMatrix(sc,size);
				break;
			case 3:
//				Check if the matrix is null
				if(matrix==null) {
					System.out.println("Enter data into the matrix first...");
					break;
				}
				
//				Get the String to Search
				System.out.println("Enter a string to search in the matrix: ");
				String string = sc.nextLine();
				
//				Print the Matrix
				System.out.println("Matrix: ");
				u.printMatrix(matrix);

//				Print the Result
				if(isStringPresent(matrix, string)) {
					System.out.println("String " + string + " Found!");
				} else {
					System.out.println("String " + string + " Not Found!");
				}
				break;
			case 4:
				break;
	
			default:
				System.out.println("Enter a valid Option...");
				break;
			}
			
		} while(option!=4);

	}
}