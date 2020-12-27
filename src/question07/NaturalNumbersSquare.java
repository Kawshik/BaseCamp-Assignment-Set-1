package question07;

import java.util.Scanner;

public class NaturalNumbersSquare {

	static Scanner sc = new Scanner(System.in);
	static int[] squares = new int[10];
	static int i = 0;

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
	
	static void menu() {
		System.out.println("1. Enter 1 to add a numbers square: ");
		System.out.println("2. Enter 2 to show all the numbers square: ");
		System.out.println("3. Enter 3 to exit: ");
	}

	static void add(int square) {
		squares[i] = square;
		i++;
	}

	static void print() {
		System.out.print("[");
		for (int j = 0; j < i; j++) {
				if (j == i-1)
					System.out.print(squares[j]);
				else
					System.out.print(squares[j] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {
		int opt;

		do {
			menu();
			opt = getInputTypeInt(sc, "Enter a valid Option..");

			switch (opt) {
			case 1:
				System.out.println("Enter a number: ");
				int num = getInputTypeInt(sc, "Enter a valid Number..");
				if (num > 10)
					System.out.println("Enter a number less than 10...");
				else if (i == 10)
					System.out.println("Array is full cannot enter more...");
				else
					add(num * num);
				break;
			case 2:
				print();
				break;
			case 3:
				break;

			default:
				break;
			}
		} while (opt != 3);

		sc.close();
	}
}
