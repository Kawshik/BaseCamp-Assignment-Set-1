package flightTicketBoking;

public class FlightTicketsList {
	FlightTicket[] flightTickets;
	int i;
	
	public FlightTicketsList() {
		this.flightTickets = new FlightTicket[10];
		this.i = 0;
	}
	
	public void add(FlightTicket flightTicket) {
		if(i==flightTickets.length) resize();
		
		flightTickets[i] = flightTicket;
		i++;
	}
	
	void resize() {
		FlightTicket[] newFlightTickets = new FlightTicket[flightTickets.length * 2];
		for (int i = 0; i < flightTickets.length; i++) {
			newFlightTickets[i] = flightTickets[i];
		}
		flightTickets = newFlightTickets;
	}
	
	public FlightTicket[] get() {
		FlightTicket[] newFlightTickets = new FlightTicket[i];
		
		for (int i = 0; i < flightTickets.length; i++) {
			if(flightTickets[i]!=null) newFlightTickets[i] = flightTickets[i];
		}
		
		return newFlightTickets;
	}
	
	public int size() {
		return i;
	}
}

