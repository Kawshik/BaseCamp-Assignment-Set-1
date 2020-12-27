package question13;

import java.util.Scanner;

public class MatrixMultiplication {
	static int getInputTypeInt(Scanner sc, String msg) {
		int val = 0;
		do {
			if(sc.hasNextInt()) {
				val = sc.nextInt();
				sc.nextLine();
				return val;
			} else {
				System.out.println(msg);
				sc.nextLine();
			}
		} while(true);
	}
	
	static int[][] createMatrix(Scanner sc){
		
		System.out.println("Enter the size of the matrix: ");
		
		System.out.println("Enter the row size: ");
		
		int row = getInputTypeInt(sc, "Enter a valid number");
		while (row < 0) {
			System.out.println("Enter a valid Size: ");
			row = getInputTypeInt(sc, "Enter a valid size...");
		}
		
		System.out.println("Enter the column size: ");
		
		int col = getInputTypeInt(sc, "Enter a valid number");
		while (col < 0) {
			System.out.println("Enter a valid Size: ");
			col = getInputTypeInt(sc, "Enter a valid size...");
		}
		
		
		int[][] matrix = new int[row][col];
		for(int i=0;i<row;i++) {
			System.out.println("Enter the "+(i+1)+" row");
			for(int j=0;j<col;j++) {
				matrix[i][j] = getInputTypeInt(sc, "Enter a valid Integer...");
			}
		}
		
		return matrix;
	}
	
	static void multiplyMatrix(int matrix1[][], int matrix2[][]){
		int c[][] = new int[matrix1.length][matrix2[0].length]; 
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < matrix1[0].length; k++) {
					c[i][j] += matrix1[i][k] * matrix2[k][j];
				} 
				System.out.print(c[i][j] + " ");
			} 
			System.out.println();
		}
	}
	
	public static  boolean isMultiplyable(int[][] matrix1, int[][] matrix2) {
		return (matrix1[0].length == matrix2.length);
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

//		int a[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 2, 2, 2, 2 } };
//		int b[][] = { { 1, 1, 1 }, { 2, 2, 2 },{2,2,2},{2,2,2} };

		Scanner sc = new Scanner(System.in);

		int[][] matrix1 = createMatrix(sc);
//		printMatrix(matrix1);
		
		int[][] matrix2 = createMatrix(sc);
//		printMatrix(matrix2);
		
		if(isMultiplyable(matrix1, matrix2))
			multiplyMatrix(matrix1, matrix2);
		else
			System.out.println("Matrices are not multipliable...");
			
	}
}
