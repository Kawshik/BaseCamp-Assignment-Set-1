package utils;

import java.util.Scanner;

public class Utils {

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
	
	public static double getInputTypeDouble(Scanner sc, String msg) {
		double val = 0;
		do {
			if (sc.hasNextDouble()) {
				val = sc.nextDouble();
				sc.nextLine();
				return val;
			} else {
				System.out.println(msg);
				sc.nextLine();
			}
		} while (true);
	}
	
	public static float getInputTypeFloat(Scanner sc, String msg) {
		float val = 0;
		do {
			if (sc.hasNextFloat()) {
				val = sc.nextFloat();
				sc.nextLine();
				return val;
			} else {
				System.out.println(msg);
				sc.nextLine();
			}
		} while (true);
	}
	
	public static char getInputTypeChar(Scanner sc, String msg) {
		do {
			String s = sc.nextLine();
			if(s.equals("")) {
				System.out.println(msg);
			} else {
				return s.charAt(0);
			}
		} while(true);
	}
	
	public static boolean isUpperCase(char c) {
		return ((int) c >= 65 && (int) c <= 90);
	}
	
	public static boolean isDigit(char c) {
		return ((int) c >= 48 && (int) c <= 57);
	}
	
	public static boolean isPhoneNumber(String phno) {
		if(phno.length()!=10) return false;
		
		for (int i = 0; i < phno.length(); i++) {
			if(!isDigit(phno.charAt(i)))
				return false;
		}
		
		return true;
	}
	
	public static int stringToNumber(String digits) {
		int number = 0;

		for (int i = 0; i < digits.length(); i++) {
			number *= 10;
			number += (isDigit(digits.charAt(i))) ? (int) digits.charAt(i) - 48 : -1;
		}

		return number;
	}

	static String[] splitByToken(String s, char token) {
		String[] subStrings = new String[2];
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == token) {
				subStrings[0] = temp;
				temp = "";
			} else {
				temp += s.charAt(i);
			}
		}
		subStrings[1] = temp;
		return subStrings;
	}
	
	public static String reverseString(String s){
		String reversed = "";
		for(int i = s.length()-1;i>=0;i--) {
			reversed+=s.charAt(i);
		}
		
		return reversed;
	}
	
	public static boolean isTime12(String time) {
		int tokenCount = 0;

		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i) == ':')
				tokenCount++;
		}

		if (tokenCount != 1)
			return false;

		String[] hoursAndMins = splitByToken(time, ':');
		if (stringToNumber(hoursAndMins[0]) <= 0 || stringToNumber(hoursAndMins[0]) > 12)
			return false;
		if (stringToNumber(hoursAndMins[1]) < 0 || stringToNumber(hoursAndMins[1]) >= 60)
			return false;

		return true;
	}
	
	public static boolean isTime24(String time) {
		int tokenCount = 0;

		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i) == ':')
				tokenCount++;
		}

		if (tokenCount != 1)
			return false;

		String[] hoursAndMins = splitByToken(time, ':');
		if (stringToNumber(hoursAndMins[0]) <= 0 || stringToNumber(hoursAndMins[0]) > 24)
			return false;
		if (stringToNumber(hoursAndMins[1]) < 0 || stringToNumber(hoursAndMins[1]) >= 60)
			return false;

		return true;
	}
	
	public static boolean isChar(char c) {
		return ((int) c >= 96 && (int) c <= 122) || ((int) c >= 65 && (int) c <= 91);
	}

	public static boolean isUpperCaseChar(char c) {
		return ((int) c >= 65 && (int) c <= 91);
	}
	
	public static boolean isLowerCaseChar(char c) {
		return ((int) c >= 96 && (int) c <= 122);
	}
	
	public static char toLowerCase(char c) {
		return (isUpperCaseChar(c))?(char)(c+32):c;
	}
	
	public static char toUpperCase(char c) {
		return (isLowerCaseChar(c))?(char)(c-32):c;
	}
	
	public static String toUpperCase(String s) {
		String upper = "";
		for (int i = 0; i < s.length(); i++) {
			if(isLowerCaseChar(s.charAt(i))) upper+=toUpperCase(s.charAt(i));
			else upper+=s.charAt(i);
		}
		return upper;
	}
	
	public static String[] split(String s, char token) {
//		Count the total number of splits
		int tokenCount = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == token) {
				tokenCount++;
			}
		}
		
		String[] splits = new String[tokenCount+1];
		
		String temp = "";
		int tokenItr = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == token) {
				splits[tokenItr] = temp;
				tokenItr++;
				temp = "";
			} else {
				temp+=s.charAt(i);
			}
		}
		splits[tokenItr] = temp;  //For the left over strings in s
		
		return splits;
	}
	
	public static boolean isDate(String date){
		// Splitting the date
		String[] dateSplit = split(date,'-');
		
		if(dateSplit.length!=3) return false;
		
		// Checking the format (dd-mm-yyyy)
		if(isDay(dateSplit[0]) && isMonth(dateSplit[1]) && isYear(dateSplit[2])) return true;
		else return false;
	}
	
	public static boolean isDay(String d) {
		int num = 0;
		if(d.length()!=2) return false;
		num += ( (int)d.charAt(0) - (int)'0' ) * 10; 
		num += ( (int)d.charAt(1) - (int)'0' );
		
		
		if(num>0 && num<=31) return true;
		else return false;
	}
	
	public static boolean isMonth(String m) {
		int num = 0;
		if(m.length()!=2) return false;
		num += ( (int)m.charAt(0) - (int)'0' ) * 10; 
		num += ( (int)m.charAt(1) - (int)'0' );


		if(num>0 && num<=12) return true;
		else return false;
	}
	
	public static boolean isYear(String y) {
		int EARLIEST_YEAR = 1000;
		int LATEST_YEAR = 2020;
		int num = 0;
		if(y.length()!=4) return false;
		num = (num + (int)y.charAt(0) - (int)'0' ) * 10;
		num = (num + (int)y.charAt(1) - (int)'0' ) * 10;
		num = (num + (int)y.charAt(2) - (int)'0' ) * 10;
		num = (num + (int)y.charAt(3) - (int)'0' );
		
		
		if(num>=EARLIEST_YEAR && num<=LATEST_YEAR) return true;
		else return false;
	}
	
	public static boolean isAge(int age){			
		int MIN_AGE = 18;
		int MAX_AGE = 80;
		return (age <= MAX_AGE) && (age >= MIN_AGE);
	}	
	
	public static int[] splitTime(String time) {
		int[] hhmm = new int[2];
		
		String[] splitTime = split(time, ':');
		hhmm[0] = stringToNumber(splitTime[0]);
		hhmm[1] = stringToNumber(splitTime[1]);
		
		return hhmm;
	}
	
	public static int[] splitDate(String date) {
		int[] ddmmyyyy = new int[3];
		
		String[] splitDate = split(date, '-');
		ddmmyyyy[0] = stringToNumber(splitDate[0]);
		ddmmyyyy[1] = stringToNumber(splitDate[1]);
		ddmmyyyy[2] = stringToNumber(splitDate[2]);
		
		return ddmmyyyy;
	}
	
	public static String toDate(int dd, int mm, int yyyy) {
		return ((dd<10)?"0"+dd:dd) + "-" + ((mm<10)?"0"+mm:mm) + "-"+yyyy+"";
	}
	
	public static String toTime(int hh, int mm) {
		return ((hh<10)?"0"+hh:hh) + ":" + ((mm<10)?"0"+mm:mm) + "";
	}
}