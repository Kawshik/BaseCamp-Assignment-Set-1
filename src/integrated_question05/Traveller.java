package integrated_question05;

public class Traveller {
	String name;
	String phoneNumber;
	TicketsList tickets;

	public Traveller(String name, String phoneNumber, TicketsList tickets) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.tickets = tickets;
	}

	public Traveller() {

	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public TicketsList getTickets() {
		return tickets;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setTickets(TicketsList tickets) {
		this.tickets = tickets;
	}
}
