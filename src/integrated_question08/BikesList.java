package integrated_question08;

public class BikesList {
	Bike[] bike;
	int i;

	public BikesList() {
		this.bike = new Bike[10];
		this.i = 0;
	}

	public void add(Bike bike) {
		if(i==this.bike.length) resize();
		this.bike[i] = bike;
		i++;
	}

	private void resize() {
		Bike[] newBikes = new Bike[this.bike.length * 2];
		for (int i = 0; i < this.bike.length; i++) {
			newBikes[i] = this.bike[i];
		}
		this.bike = newBikes;
	}

	public Bike[] get() {
		Bike[] bikes = new Bike[i];
		for (int i = 0; i < this.bike.length; i++) {
			if (this.bike[i] != null)
				bikes[i] = this.bike[i];
		}
		return bikes;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			if (this.bike[i] != null)
				System.out.println(this.bike[i]);
		}
	}
}
