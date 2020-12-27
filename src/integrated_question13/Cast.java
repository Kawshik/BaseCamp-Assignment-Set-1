package integrated_question13;

public class Cast {
	String name;

	public Cast(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cast [name=" + name + "]";
	}
	
}
