package integrated_question06;

public class TaxisList {
	Taxi[] taxis;
	int i;

	public TaxisList() {
		this.taxis = new Taxi[10];
		this.i = 0;
	}

	public void add(Taxi taxis) {
		if(i==this.taxis.length) resize();
		this.taxis[i] = taxis;
		i++;
	}

	private void resize() {
		Taxi[] newTaxis = new Taxi[this.taxis.length * 2];
		for (int i = 0; i < this.taxis.length; i++) {
			newTaxis[i] = this.taxis[i];
		}
		this.taxis = newTaxis;
	}

	public Taxi[] get() {
		Taxi[] taxis = new Taxi[i];
		for (int i = 0; i < this.taxis.length; i++) {
			if (this.taxis[i] != null)
				taxis[i] = this.taxis[i];
		}
		return taxis;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			System.out.println(taxis[i]);
		}
	}
}
