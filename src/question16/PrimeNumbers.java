package question16;

import java.util.Scanner;

public class PrimeNumbers {
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
	
	public static int[] createArray(Scanner sc, int size) {
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++) {
			System.out.println("Enter element no "+(i+1)+": ");
			
			array[i] = getInputTypeInt(sc, "Enter a valid Integer...");
		}
		
		return array;
	}
	
	public static boolean isPrime(int num) {
		if(num==0 || num==1) return false;
		
		if(num==2) return true;
		
		for(int i = 2; i<=num/2;i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}
	
	public static int[] getAllPrimes(int[] array) {
		int primeCount = 0;
		
		
		for(int i=0;i<array.length;i++) {
			if(isPrime(array[i])) {				
				primeCount++;
			} else {
				array[i] = 0;
			}
		}
		
		int[] primes = new int[primeCount];
		if(primeCount==0) return primes;
		
		else {
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				if(array[i]!=0) {
					primes[j]=array[i];
					j++;
				}
				
				//gets out of the loop if all the primes 
				//are in the primes array and there are 
				//more elements in the main array 
				if(j==primeCount) break; 
			}
		}
		return primes;
	}
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if(i==array.length-1) System.out.print(array[i]);
			else System.out.print(array[i] + ", ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array: ");
		int size = getInputTypeInt(sc, "Enter a valid size in Integer...");
		int[] array = createArray(sc, size);
		int[] primes = getAllPrimes(array);
		System.out.println("All the primes in the array are: ");
		printArray(primes);
	}
}
