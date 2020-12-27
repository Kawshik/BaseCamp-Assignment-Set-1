package integrated_question04;

public class Bill {
	ItemsList items;
	double totalBill;
	
	public Bill(ItemsList items, double totalBill) {
		super();
		this.items = items;
		this.totalBill = totalBill;
	}

	public ItemsList getItems() {
		return items;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setItems(ItemsList items) {
		this.items = items;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		items.print();
		return "totalBill=" + totalBill;
	}

}
