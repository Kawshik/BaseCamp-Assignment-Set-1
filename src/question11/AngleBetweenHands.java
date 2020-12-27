package question11;

import java.util.Scanner;

public class AngleBetweenHands {

	public static final double HOUR_HAND_DEGREE = 30;
	public static final double MINUTE_HAND_DEGREE = 6;
	public static final double TOTAL_MINUTES = 60;

	static boolean isDigit(char c) {
		return ((int) c >= 48 && (int) c <= 57);
	}

	static int stringToNumber(String digits) {
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

	static boolean isTime(String time) {
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

	static double getDegree(int[] hoursAndMins) {
		double deg = 0.0;

		double hourDeg = (hoursAndMins[0] + (hoursAndMins[1] / TOTAL_MINUTES)) * HOUR_HAND_DEGREE;
		double minDeg = hoursAndMins[1] * MINUTE_HAND_DEGREE;

		deg = (hourDeg > minDeg) ? hourDeg - minDeg : minDeg - hourDeg;

		return deg;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Time(e.g 5:15): ");
		String time = sc.nextLine();

		if (isTime(time)) {
			String[] hoursAndMins = splitByToken(time, ':');

			int[] times = { stringToNumber(hoursAndMins[0]), stringToNumber(hoursAndMins[1]) };

			System.out.println(getDegree(times));
		} else {
			System.out.println("Enter a valid Time...");
		}
		
		sc.close();
	}

}
