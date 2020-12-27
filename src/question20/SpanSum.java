package question20;

import java.util.Scanner;

public class SpanSum {

	//	handles Input mismatch exception
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
	
	public static int[] createArray(Scanner sc) {
		System.out.println("Enter the size of the array: ");
		int size = getInputTypeInt(sc, "Enter a valid Number...");
		int[] arr = new int[size];
		for(int i=0;i<size;i++) {
			System.out.println("Enter element no " + (i+1));
			arr[i] = getInputTypeInt(sc, "Enter a valid Number...");
		}
		
		return arr;
	}
	
	static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	static int calculateSpanSum(int[] arr){
		int sum = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = createArray(sc);
		printArr(arr);
		System.out.println("Span Sum: " + calculateSpanSum(arr));
	}
}
