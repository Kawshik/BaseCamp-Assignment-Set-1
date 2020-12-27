package integrated_question05;

public class TravellersList {
	Traveller[] travellers;
	int i;

	public TravellersList() {
		this.travellers = new Traveller[10];
		this.i = 0;
	}

	public void add(Traveller traveller) {
		if(i==this.travellers.length) resize();
		this.travellers[i] = traveller;
		i++;
	}

	private void resize() {
		Traveller[] newTravellers = new Traveller[this.travellers.length * 2];
		for (int i = 0; i < this.travellers.length; i++) {
			newTravellers[i] = this.travellers[i];
		}
		this.travellers = newTravellers;
	}

	public Traveller[] get() {
		Traveller[] travellers = new Traveller[i];
		for (int i = 0; i < this.travellers.length; i++) {
			if (this.travellers[i] != null)
				travellers[i] = this.travellers[i];
		}
		return travellers;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			System.out.println(travellers[i]);
		}
	}
}
