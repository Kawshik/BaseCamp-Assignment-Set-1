package question15;

import java.util.Scanner;

public class MatrixManipulation {
	
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

//	createMatrix
	public static int[][] createSquareMatrix(Scanner sc, int m, int n) {

		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			System.out.println("Enter the values for Row " + (i + 1));
			for (int j = 0; j < n; j++) {
				System.out.println("Enter the value for Column " + (j + 1));
				matrix[i][j] = getInputTypeInt(sc, "Enter a valid Character...");
			}
		}

		return matrix;
	}

//	multiplyRow
	public static int[][] multiplyRow(int[][] matrix){
		int[][] result = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = matrix[i][j] * i;
			}
		}
		return result;
	}
	
//	printMatrix
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array: ");
		System.out.println("Rows: ");
		int m = getInputTypeInt(sc, "Enter a valid Integer");
		
		System.out.println("Columns: ");
		int n = getInputTypeInt(sc, "Enter a valid Integer");;
		
		System.out.println("Start etering values into the matrix: ");
		int[][] matrix = createSquareMatrix(sc, m, n); 
		
		System.out.println("Initial Matrix: ");
		printMatrix(matrix);
		
		System.out.println();
		
		int[][] result = multiplyRow(matrix);
		System.out.println("Final Matrix: ");
		printMatrix(result);
		
		sc.close();
	}
}
