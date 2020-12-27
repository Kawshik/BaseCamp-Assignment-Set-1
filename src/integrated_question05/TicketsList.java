package integrated_question05;

public class TicketsList {
	Ticket[] tickets;
	int i;

	public TicketsList() {
		this.tickets = new Ticket[10];
		this.i = 0;
	}

	public void add(Ticket ticket) {
		if(i==this.tickets.length) resize();
		this.tickets[i] = ticket;
		i++;
	}

	private void resize() {
		Ticket[] newTickets = new Ticket[this.tickets.length * 2];
		for (int i = 0; i < this.tickets.length; i++) {
			newTickets[i] = this.tickets[i];
		}
		this.tickets = newTickets;
	}

	public Ticket[] get() {
		Ticket[] tickets = new Ticket[i];
		for (int i = 0; i < this.tickets.length; i++) {
			if (this.tickets[i] != null)
				tickets[i] = this.tickets[i];
		}
		return tickets;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			System.out.println(tickets[i]);
		}
	}
}
