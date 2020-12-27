package integrated_question01;

public class ParkingSlot {
	String carNumber;
	String entryTime;
	
	public ParkingSlot(String carNumber, String entryTime) {
		super();
		this.carNumber = carNumber;
		this.entryTime = entryTime;
	}

	public ParkingSlot() {
		
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	@Override
	public String toString() {
		return "ParkingSlot [carNumber=" + carNumber + ", entryTime=" + entryTime + "]";
	}
	
	
}
