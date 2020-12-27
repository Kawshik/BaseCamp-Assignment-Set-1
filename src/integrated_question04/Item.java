package integrated_question04;

public class Item {
	String id;
	double price;
	int discount;

	public Item(String id, double price, int discount) {
		super();
		this.id = id;
		this.price = price;
		this.discount = discount;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", discount=" + discount + "]";
	}

}
