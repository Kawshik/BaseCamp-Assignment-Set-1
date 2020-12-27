package integrated_question01;

import java.util.Scanner;

import utils.Utils;

public class ParkingTicketBookingApp {

	static ParkingSlot[] parkingSlots = new ParkingSlot[100];
	static Scanner sc;

	public static int slotsAvaliableCount() {
		int slotCounter = 0;
		for (int i = 0; i < parkingSlots.length; i++) {
			if (parkingSlots[i] == null)
				slotCounter++;
		}
		return slotCounter;
	}

	public static void menu() {
		System.out.println("PARKING TICKET BOOKING");
		System.out.println("Available Slots: " + slotsAvaliableCount());
		System.out.println("1. Enter 1 to Book a Slot.");
		System.out.println("2. Enter 2 to Empty a Slot.");
		System.out.println("3. Enter 3 to Exit.");
	}

	static int getAvailableSlot() {
		for (int i = 0; i < parkingSlots.length; i++) {
			if (parkingSlots[i] == null)
				return i;
		}
		return -1;
	}

	static void allocateEmptySlot() {
//		Create a Parking Slot
		System.out.println("Enter Car Number: ");
		String carNo = sc.nextLine();

		System.out.println("Enter the Entry Time: (in 24hr Format))");
		String entryTime = sc.nextLine();
		if (!Utils.isTime24(entryTime)) {
			System.out.println("Enter a valid Time...");
			return;
		}

		ParkingSlot parkingSlot = new ParkingSlot(carNo, entryTime);

		int emptyIndex = getAvailableSlot();

		parkingSlots[emptyIndex] = parkingSlot;
	}

	static int getParkingHours(String entryTime, String exitTime) {
		int entryHour = Utils.stringToNumber(entryTime.charAt(0) + "" + entryTime.charAt(1));
		int exitHour = Utils.stringToNumber(exitTime.charAt(0) + "" + exitTime.charAt(1));

		return (entryHour > exitHour) ? entryHour - exitHour : exitHour - entryHour;
	}

	static int calculateFee(int hours) {
		return (hours > 2) ? 50 + ((hours - 2) * 30) : 50;
	}

	static ParkingSlot getSlotByCarNo(String carNo) {
		for (int i = 0; i < parkingSlots.length; i++) {
			if(parkingSlots[i]!=null && parkingSlots[i].carNumber.equals(carNo))
				return parkingSlots[i];
		}
		return null;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int opt;
		do {
			menu();
			System.out.println("Enter a Option: ");
			opt = Utils.getInputTypeInt(sc, "Enter a Valid Option(1 - 3)...");
			
			switch (opt) {
			case 1:
				allocateEmptySlot();
				break;
			case 2:
				System.out.println("Enter the Car Number: ");
				String carNo = sc.nextLine();
				System.out.println("Enter the Exit Time: ");
				String exitTime = sc.nextLine();
				if (!Utils.isTime24(exitTime)) {
					System.out.println("Enter a valid Time...");
				}

				ParkingSlot slot = getSlotByCarNo(carNo);
				if(slot==null)
					System.out.println("No car of that number is found.");
				else
					System.out.println("Total Fee: " + calculateFee(getParkingHours(slot.entryTime, exitTime)));
				break;		
			case 3:
				break;
			default:
				break;
			}
		} while(opt!=3);

		sc.close();
	}
}
