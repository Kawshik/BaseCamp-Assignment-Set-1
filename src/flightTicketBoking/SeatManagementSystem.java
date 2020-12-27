package flightTicketBoking;

public class SeatManagementSystem {
	private int[][] seats;
	private int rows;
	private int cols;

	private int availableSeats;

	public SeatManagementSystem() {
		this.rows = 30;
		this.cols = 6;
		seats = new int[rows][cols];
		availableSeats = getTotalAvailableSeats();
	}

	public SeatManagementSystem(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		seats = new int[rows][cols];
		availableSeats = getTotalAvailableSeats();
	}

	public int getRows() {
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	public int getTotalAvailableSeats() {
		return availableSeats;
	}

	public boolean isValidSeatNumber(String seatNumber) {
		int[] seatRowCol = getSeatRowCol(seatNumber);
		if (seatRowCol[0] > this.rows)
			return false;
		if (seatRowCol[1] > this.cols)
			return false;

		return true;
	}

	public boolean isSeatAvailable(String seatNumber) {
		int[] seatRowCol = getSeatRowCol(seatNumber);
		
		if (this.seats[seatRowCol[0]][seatRowCol[1]] == 0)
			return true;
		else
			return false;
	}

	public int[] getSeatRowCol(String seatNumber) {
		int row = 0;
		for(int i=0;i<seatNumber.length() -1 ;i++) {
			row*=10;
			row += seatNumber.charAt(i) - 48;
		}
		
		row-=1;
		
		int col = seatNumber.charAt(seatNumber.length()-1) - 'A';

		int[] seatRowCol = { row, col };
		return seatRowCol;
	}

	public SeatBookingStatus bookSeatBySeatNumber(String seatNumber) {
		String errorMsg = "";
		String successMsg = "";

		if (!isValidSeatNumber(seatNumber)) {
			errorMsg = "Invalid Seat Number...";
			return new SeatBookingStatus(errorMsg, false);
		}

		if (!isSeatAvailable(seatNumber)) {
			errorMsg = "Seat Already Booked...";
			return new SeatBookingStatus(errorMsg, false);
		}

		int[] rowCol = getSeatRowCol(seatNumber);

		seats[rowCol[0]][rowCol[1]] = 1;
		availableSeats--;
		successMsg = "Seat Booked Succesfully...";
		
		return new SeatBookingStatus(successMsg, true);
	}

	public String bookSeat() {

		if(availableSeats==0) return null;
		
		String seatNo = "";

		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j] == 0) {
					seatNo += (i + 1);
					seatNo += (char) ('A' + j);
					seats[i][j] = 1;
					availableSeats--;
					return seatNo;
				}
			}
		}

		return seatNo;
	}
	
	public void showSeatPlan() {
		for(int i = 0;i<seats.length;i++) {
			for (int j = 0; j < seats[i].length; j++) {
				int rowNum = i;
				char colName = (char)('A'+ j);
				
				if(seats[i][j]!=0)
					System.out.print("    ");
				else
					System.out.print((rowNum+1) + "" +colName + "   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SeatManagementSystem sms = new SeatManagementSystem();
		System.out.println(sms.getSeatRowCol("14F")[1]);
		System.out.println(sms.isValidSeatNumber("24F"));
	}
}
