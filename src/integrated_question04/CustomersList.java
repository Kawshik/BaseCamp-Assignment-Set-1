package integrated_question04;

public class CustomersList {
	Customer[] customers;
	int i;

	public CustomersList() {
		this.customers = new Customer[10];
		this.i = 0;
	}

	public void add(Customer customer) {
		if(i==this.customers.length) resize();
		this.customers[i] = customer;
		i++;
	}

	private void resize() {
		Customer[] newCustomers = new Customer[this.customers.length * 2];
		for (int i = 0; i < this.customers.length; i++) {
			newCustomers[i] = this.customers[i];
		}
		this.customers = newCustomers;
	}

	public Customer[] get() {
		Customer[] customers = new Customer[i];
		for (int i = 0; i < this.customers.length; i++) {
			if (this.customers[i] != null)
				customers[i] = this.customers[i];
		}
		return customers;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			System.out.println(this.customers[i]);
		}
	}
}
