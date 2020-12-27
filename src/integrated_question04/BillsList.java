package integrated_question04;

public class BillsList {
	Bill[] bills;
	int i;

	public BillsList() {
		this.bills = new Bill[10];
		this.i = 0;
	}

	public void add(Bill bill) {
		if(i==this.bills.length) resize();
		this.bills[i] = bill;
		i++;
	}

	private void resize() {
		Bill[] newBills = new Bill[this.bills.length * 2];
		for (int i = 0; i < this.bills.length; i++) {
			newBills[i] = this.bills[i];
		}
		this.bills = newBills;
	}

	public Bill[] get() {
		Bill[] bills = new Bill[i];
		for (int i = 0; i < this.bills.length; i++) {
			if (this.bills[i] != null)
				bills[i] = this.bills[i];
		}
		return bills;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			if (this.bills[i] != null)
				System.out.println(this.bills[i]);
		}
	}
}
