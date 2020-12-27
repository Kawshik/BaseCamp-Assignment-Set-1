package flightTicketBoking;

public class FlightTicket {
	private String departureCity;
	private String arrivalCity;
	private String flightNumber;
	private String seatNumber;
	
	public FlightTicket(String departureCity, String arrivalCity, String flightNumber, String seatNumber) {
		super();
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
	}

	public FlightTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}	
}
