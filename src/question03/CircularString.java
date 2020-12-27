package question03;

import java.util.Scanner;

public class CircularString {

//	baseString is the user input string
//	subString is the string that is to be computed
//	startIndex are the starting index position of the subString in the baseString
//	endIndex are the ending index position of the subString in the baseString
	public static boolean isSubString(String baseString, String subString, int[] indices) {
		int startIndex = indices[0];
		int endIndex = indices[1];

		for (int i = startIndex; i < endIndex; i++) {
			if (baseString.charAt(i) != subString.charAt(i - startIndex))
				return false;
		}

		return true;
	}

	static int stringToInt(String s) {
		int num = 0;
		for(int i = 0; i < s.length(); i++) {
			num*=10;
			num += (int)s.charAt(i)-48;
		}
		
		return num;
	}
	
	static int[] getIntArray(String s, int size) {
		int[] arr = new int[size];
		int j = 0;
		String num = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 32) {
				arr[j] = stringToInt(num);
				num = "";
				j++;
			} else {
				num += s.charAt(i);
			}
		}
		return arr;
	}

	static boolean isCircular(String baseString, String circularString) {
//		Determine the positions of the starting character of the base string in the circular string
		String startCharacterPositions = "";  //Stored in string to avoid dynamic array creation
		int count = 0;
		for (int i = 0; i < circularString.length(); i++) {
			if (baseString.charAt(0) == circularString.charAt(i)) {
				startCharacterPositions += i + " ";
				count++;
			}
		}

		int[] startCharPositions = getIntArray(startCharacterPositions, count);
		boolean flag = false;

		for (int i = 0; i < startCharPositions.length; i++) { //If there are more than one first char match
			int startCharPos = startCharPositions[i];
//		Divide the string into two half's using the starting positions and the circular string
			String firstHalfSub = "";
			for (int j = startCharPos; j < circularString.length(); j++) {
				firstHalfSub += circularString.charAt(j);
			}

			String secondHalfSub = "";
			for (int j = 0; j < startCharPos; j++) {
				secondHalfSub += circularString.charAt(j);
			}

//		Determine the indices of both the half's from the base String
			int[] firstHalfIndex = { 0, baseString.length() - startCharPos - 1 };

			int[] secondHalfIndex = { baseString.length() - startCharPos, baseString.length() - 1 };

//		Check if both the half's are substrings of the base string
			if (isSubString(baseString, firstHalfSub, firstHalfIndex)
					&& isSubString(baseString, secondHalfSub, secondHalfIndex))
				flag = true;
			else
				flag = false;
			
			
			if (flag == true)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
//		String baseString = "ABCDE";
//		String circularString = "CDEAB";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String baseString = sc.nextLine();
		System.out.println("Enter another String: ");
		String circularString = sc.nextLine();
		
		if(isCircular(baseString, circularString))
			System.out.println(baseString + " and " + circularString + " are Circular");
		else 
			System.out.println(baseString + " and " + circularString + " are Not Circular");
		

		sc.close();
	}
}
