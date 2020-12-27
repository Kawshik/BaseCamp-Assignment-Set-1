package integrated_question04;

public class Customer {
	private String phoneNumber;
	private BillsList bills;
	private double totalBillTillDate;
	
	public Customer(String phoneNumber, BillsList bills, double totalBill) {
		super();
		this.phoneNumber = phoneNumber;
		this.bills = bills;
		this.totalBillTillDate = totalBill;
	}
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}

	public BillsList getBills() {
		return bills;
	}

	public double gettotalBillTillDate() {
		return totalBillTillDate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setBills(BillsList bills) {
		this.bills = bills;
	}

	public void settotalBillTillDate(double totalBillTillDate) {
		this.totalBillTillDate = totalBillTillDate;
	}

	@Override
	public String toString() {
//		this.bills.print();
		return "Customer [phoneNumber=" + phoneNumber + ", totalBill=" + totalBillTillDate + "]";
	}
}
