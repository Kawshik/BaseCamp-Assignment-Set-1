package integrated_question02;

public class VisitorsList {
	Visitor[] visitors;
	int i;
	
	public VisitorsList() {
		this.visitors = new Visitor[10];
		this.i = 0;
	}
		
	public void add(Visitor visitor) {
		if(i==visitors.length) resize();
		
		visitors[i] = visitor;
		i++;
	}
	
	void resize() {
		Visitor[] newVisitors = new Visitor[visitors.length * 2];
		for (int i = 0; i < visitors.length; i++) {
			newVisitors[i] = visitors[i];
		}
		visitors = newVisitors;
	}
	
	public Visitor[] get() {
		return this.visitors;
	}
	
	public int size() {
		return i;
	}
}
