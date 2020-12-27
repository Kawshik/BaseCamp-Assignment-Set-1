package integrated_question05;


public class TravellerManagementSystem extends TravelAgentApp{
	TravellersList travellers;

	
	
	public TravellerManagementSystem() {
		travellers = new TravellersList();
	}

	public TravellersList getTravellers() {
		return travellers;
	}
	
	public Traveller searchTraveller(String name, String phno) {
		Traveller[] travellers = this.travellers.get();
		for (int i = 0; i < travellers.length; i++) {
			if(travellers[i].getName().equals(name) && travellers[i].getPhoneNumber().equals(phno)) {
				return travellers[i];
			}
		}
		
		return null;
	}
	
	public Traveller getOrCreateTraveller() {
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();
		
		Traveller t = searchTraveller(name, phoneNumber);
		
		if(t==null) {
			travellers.add(new Traveller(name,phoneNumber,new TicketsList()));
			return travellers.get()[travellers.size() - 1];
		} else {
			return t;
		}
	}
	
	public String mostPreferredDestination(Traveller t) {
		Ticket[] tickets = t.getTickets().get();
		
		Map map = new Map();
		
		for (int i = 0; i < tickets.length; i++) {
			if(map.contains(tickets[i].getDestination()))
				map.update(tickets[i].getDestination(), map.getValue(tickets[i].getDestination() + 1));
			else
				map.add(tickets[i].getDestination());
		}
		
		int max = 0;
		String mostPreferredDest = "";
		Node[] nodes = map.getNodes();
		
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i].getValue() > max) {
				max = nodes[i].getValue();
				mostPreferredDest = nodes[i].getKey();
			}
		}
		
		return mostPreferredDest;
	}
}
