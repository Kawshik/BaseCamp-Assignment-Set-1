package integrated_question13;

public class CastsList {
	String[] casts;
	int i;

	public CastsList() {
		this.casts = new String[10];
		this.i = 0;
	}

	public void add(String cast) {
		if(i==this.casts.length) resize();
		this.casts[i] = cast;
		i++;
	}

	private void resize() {
		String[] newCasts = new String[this.casts.length * 2];
		for (int i = 0; i < this.casts.length; i++) {
			newCasts[i] = this.casts[i];
		}
		this.casts = newCasts;
	}

	public String[] get() {
		String[] cast = new String[i];
		for (int i = 0; i < this.casts.length; i++) {
			if (this.casts[i] != null)
				cast[i] = this.casts[i];
		}
		return cast;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			if (this.casts[i] != null)
				System.out.println(this.casts[i]);
		}
	}
}
