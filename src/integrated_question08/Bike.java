package integrated_question08;

public class Bike {
	String make;
	String model;
	String type;
	String engine;
	double price;

	public Bike(String make, String model, String type, String engine, double price) {
		super();
		this.make = make;
		this.model = model;
		this.type = type;
		this.engine = engine;
		this.price = price;
	}

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getEngine() {
		return engine;
	}

	public double getPrice() {
		return price;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bike [make=" + make + ", model=" + model + ", type=" + type + ", engine=" + engine + ", price=" + price
				+ "]";
	}
}
