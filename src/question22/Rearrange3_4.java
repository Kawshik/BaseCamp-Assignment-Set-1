package question22;

import java.util.Scanner;

public class Rearrange3_4 {
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
	
	static int[] createArray(Scanner sc, int size) {
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter Element No: " + (i+1));
			arr[i] = getInputTypeInt(sc, "Enter a valid Number...");
		}
		
		return arr;
	}
	
	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static int[] rearrange3_4(int[] arr) {		
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] == 3) {
				for(int j = 0;j<arr.length;j++) {
					if(arr[j]==4) {
						if(j!=0 && arr[j-1] != 3) {
							int temp = arr[i+1];
							arr[i+1] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array: ");
		int size = getInputTypeInt(sc, "Enter a valid Size...");
		int[] arr = createArray(sc, size);
		printArr(rearrange3_4(arr));
	}

	
}
