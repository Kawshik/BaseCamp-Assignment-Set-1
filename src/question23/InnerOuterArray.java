package question23;

import java.util.Scanner;

public class InnerOuterArray {
	
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
		for (int i = 0; i < size; i++) {
			System.out.println("Enter element no " + (i + 1));
			arr[i] = getInputTypeInt(sc, "Enter a valid Number...");
		}

		return arr;
	}
	
	static boolean isInner(int[] innerArr, int[] outerArr) {
		int i = 0;
		int j = 0;
		
		while(i<innerArr.length && j<outerArr.length) {
			if(innerArr[i] < outerArr[j]) return false;
			else if(innerArr[i] == outerArr[j]) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		
		return i==innerArr.length;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] outerArr = createArray(sc);
		int[] innerArr = createArray(sc);
		
		System.out.println(isInner(innerArr, outerArr));
		
	}
}
