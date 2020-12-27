package integrated_question09;

public class Plan {
	String name;
	float internetSpeed;
	float downloadLimit;
	double price;

	public Plan(String name, float internetSpeed, float downloadLimit, double price) {
		super();
		this.name = name;
		this.internetSpeed = internetSpeed;
		this.downloadLimit = downloadLimit;
		this.price = price;
	}

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public float getInternetSpeed() {
		return internetSpeed;
	}

	public float getDownloadLimit() {
		return downloadLimit;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInternetSpeed(float internetSpeed) {
		this.internetSpeed = internetSpeed;
	}

	public void setDownloadLimit(float downloadLimit) {
		this.downloadLimit = downloadLimit;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Plan name: " + name + "\n Internet Speed: " + internetSpeed + "\n Download Limit: " + downloadLimit
				+ "\n Price=" + price;
	}
}
