package question24;

import java.util.Scanner;

public class SuperiorElement {
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
	
	public static int[][] createSquareMatrix(Scanner sc, int row, int col){
		
		int[][] matrix = new int[row][col];
		
		for(int i = 0;i<matrix[0].length;i++) {
			System.out.println("Enter the values for Row " + (i+1));
			for (int j = 0; j < matrix.length; j++) {
//				System.out.println("Enter the value for Column " + (j+1));
				do {
					System.out.println("Enter the value for Column " + (j+1));
					matrix[i][j] = getInputTypeInt(sc, "Enter a valid Character...");					
				}while(matrix[i][j]<0);
			}
		}
		
		return matrix;
	}
	
	static int[] findSuperiorElement(int[][] matrix){
		int[] index = new int[2];
		
		int largestElement = 0;
		
		for(int i = 0;i<matrix[0].length;i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[i][j]>largestElement) {
					largestElement = matrix[i][j];
					index[0] = i;
					index[1] = j;
				}
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number row of the Matrix");
		int row = getInputTypeInt(sc, "Enter a valid number");
		while (row < 0) {
			System.out.println("Enter a valid Size: ");
			row = getInputTypeInt(sc, "Enter a valid size...");
		}
		
		
		System.out.println("Enter the number columns of the Matrix");
		int col = getInputTypeInt(sc, "Enter a valid number");
		while (col < 0) {
			System.out.println("Enter a valid Size: ");
			col = getInputTypeInt(sc, "Enter a valid size...");
		}
		
		int[][] matrix = createSquareMatrix(sc, row, col);
		
		int[] superiorElementIndex = findSuperiorElement(matrix);
		
		System.out.println("The Superior Element is found in the postition: (" + superiorElementIndex[0]+","+superiorElementIndex[1]+")");
		
		sc.close();
	}
}
