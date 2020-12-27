package integrated_question05;

import utils.Utils;

public class TicketBookingSystem extends TravelAgentApp{

	/*TODO:
	 * DISPLAY:
	 * show proper message for each entry
	*/
	private int idValue;
	private final int FLIGHT_DURATION = 2;

	public TicketBookingSystem() {
		this.idValue = 1;
	}

	// create a one-way ticket -- create one ticket
	Ticket createOneWayTicket() {
		System.out.println("Enter name of the airline: ");
		String airline = sc.nextLine();
		System.out.println("Enter Source: ");
		String source = sc.nextLine();
		System.out.println("Enter Destination: ");
		String destination = sc.nextLine();
		System.out.println("Enter Departure Date : ");
		String departureDate = sc.nextLine(); 
		System.out.println("Enter Departure Time: ");
		String departureTime = sc.nextLine();
		
		String id = generateTicketId(airline);

		String[] landingDateTime = addFlightDuration(departureDate, departureTime, this.FLIGHT_DURATION);
		
		String landingDate = landingDateTime[0];
		String landingTime = landingDateTime[1];
		
		Ticket ticket = new Ticket(id,airline,source,destination,departureDate,departureTime,landingDate,landingTime);
		
		this.idValue++;
		return ticket;
	}
	
//	create a return ticket  -- create two tickets
	Ticket[] createReturnTicket() {
		Ticket[] tickets = new Ticket[2];
		
		System.out.println("Enter name of the airline: ");
		String airline = sc.nextLine();
		System.out.println("Enter Source: ");
		String source = sc.nextLine();
		System.out.println("Enter Destination: ");
		String destination = sc.nextLine();
		System.out.println("Enter Departure Date : ");
		String departureDate = sc.nextLine(); 
		System.out.println("Enter Departure Time: ");
		String departureTime = sc.nextLine();
		
		System.out.println("Enter Return Date: ");
		String arrivalDate = sc.nextLine();
		System.out.println("Enter Return Time: ");
		String arrivalTime = sc.nextLine();
		
		String departureTicketId = generateTicketId(airline);
		
		String[] departure_landingDateTime = addFlightDuration(departureDate, departureTime, this.FLIGHT_DURATION);
		
		String departure_landingDate = departure_landingDateTime[0];
		String departure_landingTime = departure_landingDateTime[1];
		
		tickets[0] = new Ticket(departureTicketId,airline,source,destination,departureDate,departureTime,departure_landingDate,departure_landingTime);
		this.idValue++;
		
		
		
		String returnTicketId = generateTicketId(airline);
		
		String[] return_landingDateTime = addFlightDuration(departureDate, departureTime, this.FLIGHT_DURATION);
		
		String return_landingDate = return_landingDateTime[0];
		String return_landingTime = return_landingDateTime[1];
		
		tickets[1] = new Ticket(returnTicketId,airline,source,destination,arrivalDate,arrivalTime,return_landingDate,return_landingTime);
		this.idValue++;
		
		return tickets;
	}

	private String generateTicketId(String airline) {
		String ticketId = "";
		String prefix = "";
		if (airline.length() > 3) {
			prefix += airline.charAt(0);
			prefix += airline.charAt(1);
			prefix += airline.charAt(2);
		} else {
			prefix += airline;
		}
		
		ticketId = Utils.toUpperCase(prefix + idValue);
		
		return ticketId;
	}
	
	static boolean isValidRoute(String departure, String arrival) {
		return Utils.toUpperCase(departure).compareTo(Utils.toUpperCase(arrival)) == 0;
	}
	
	private String[] addFlightDuration(String date, String time, int duration) {
		String arrivalDate = "";
		String arrivalTime = "";
		
		int[] arrivalDateSplit = Utils.splitDate(date);
		int[] arrivalTimeSplit = Utils.splitTime(time);
		
		int timePast = arrivalTimeSplit[0] + duration;
		if(timePast>24) {
			if((arrivalDateSplit[0]+1) > 31) {
				if(arrivalDateSplit[1]+1 > 12) {
					arrivalDateSplit[2]+=1;
					arrivalDateSplit[1] = 1;
					arrivalDateSplit[0] = 1;
				} else {
					arrivalDateSplit[1] += 1;
					arrivalDateSplit[0] = 1;
				}
			} else {
				arrivalDateSplit[0] += 1;
			}
			
			arrivalTimeSplit[0]+=timePast-24;
		} else {
			arrivalTimeSplit[0]+=duration;
		}
			
		arrivalDate = Utils.toDate(arrivalDateSplit[0], arrivalDateSplit[1], arrivalDateSplit[2]);
		arrivalTime = Utils.toTime(arrivalTimeSplit[0], arrivalTimeSplit[1]);
		
		return new String[]{arrivalDate,arrivalTime};
	}
	

}
