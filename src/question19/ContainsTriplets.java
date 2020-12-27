package question19;

import java.util.Scanner;

public class ContainsTriplets {
	
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
	
	public static boolean hasTriplets(int[] arr) {
//		if the array size is less than 3 it cannot have a triplet
		if(arr.length<3) {
			return false;
		}
		
//		if it has 3 elements than it might have a triplet
		if(arr.length == 3) {
			int temp = arr[0];
			for(int i=0;i<3;i++) {
				if(arr[i]!=temp)
					return false;
			}
		}
		
//		if the array have more than 3 elements than check all elements in a group of 3
		boolean flag = false;
		
		for(int i=0;i<arr.length - 3;i++) {
			int temp = arr[i];
			for(int j = i;j<i+3;j++) {
//				assume that the 3 elements from i is a triplet and than check if it is not
				flag = true;
				if(arr[j]==temp && flag==true)
					flag = true;
				else
					flag = false;
			}
			if(flag==true) return true;
		}
		
		return flag;
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int[] arr = {1, 1, 2, 2, 2, 1};
		
		int[] arr = createArray(sc);
		
		if(hasTriplets(arr)) 
			System.out.println("The array has a Triplet!");
		else
			System.out.println("The array does not have a Triplet!");
	}
}
