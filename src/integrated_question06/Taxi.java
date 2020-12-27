package integrated_question06;

public class Taxi {
	String taxiNumber;
	String driverName;
	String driverId;
	double distance;

	public Taxi(String taxiNumber, String driverName, String driverId, double distance) {
		super();
		this.taxiNumber = taxiNumber;
		this.driverName = driverName;
		this.driverId = driverId;
		this.distance = distance;
	}

	public Taxi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTaxiNumber() {
		return taxiNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getDriverId() {
		return driverId;
	}

	public double getDistance() {
		return distance;
	}

	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Taxi [taxiNumber=" + taxiNumber + ", driverName=" + driverName + ", driverId=" + driverId
				+ ", distance=" + distance + "]";
	}
}
