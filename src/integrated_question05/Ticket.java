package integrated_question05;

public class Ticket {
	String id;
	String airline;
	String source;
	String destination;
	String departureDate;
	String departureTime;
	String landingDate;
	String landingTime;

	public Ticket(String id, String airline, String source, String destination, String departureDate,
			String departureTime, String landingDate, String landingTime) {
		super();
		this.id = id;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.landingDate = landingDate;
		this.landingTime = landingTime;
	}

	public Ticket() {
		
	}

	public String getId() {
		return id;
	}

	public String getAirline() {
		return airline;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getLandingDate() {
		return landingDate;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", airline=" + airline + ", source=" + source + ", destination=" + destination
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", landingDate="
				+ landingDate + ", landingTime=" + landingTime + "]";
	}

	
}
