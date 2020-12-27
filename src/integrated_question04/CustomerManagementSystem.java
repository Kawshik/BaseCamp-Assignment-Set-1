package integrated_question04;

public class CustomerManagementSystem {
	private CustomersList customers;

	public CustomerManagementSystem() {
		this.customers = new CustomersList();
	}
	
	public CustomersList getCustomers() {
		return customers;
	}
	
	private Customer searchCustomer(String phno) {
		Customer[] c = customers.get();
		for (int i = 0; i < c.length; i++) {
			if (c[i].getPhoneNumber().equals(phno))
				return c[i];
		}

		return null;
	}

	public Customer getOrCreateCustomerByPhoneNumber(String phno) {
		Customer c = searchCustomer(phno);
		if (c == null) {
			customers.add(new Customer(phno, new BillsList(), 0));
			return customers.get()[customers.size() - 1];
		} else {
			return c;
		}
	}

	void printAllCustomers() {
		customers.print();
	}
	
	public Customer getMostValuedCustomer() {
		Customer[] customers = this.customers.get();
		double maxBill = 0;
		Customer mostValuedCustomer = new Customer();
		for (int i = 0; i < customers.length; i++) {
			if(customers[i].gettotalBillTillDate() > maxBill) {
				maxBill = customers[i].gettotalBillTillDate();
				mostValuedCustomer = customers[i];
			}
		}
		
		return mostValuedCustomer;
	}
}
