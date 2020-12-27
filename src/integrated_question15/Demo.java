package integrated_question15;

class Car{	
	int regN0;
	String name;
	int cost;
	public Car(int regN0, String name, int cost) {
		super();
		this.regN0 = regN0;
		this.name = name;
		this.cost = cost;
	}
	
	
}

public class Demo extends FurnitureStoreApp{
	
	public static void main(String[] args) {
		
		float f = 1;
		int i = (int) 1.2;
		
		FurnitureStoreApp fa = new Demo();
		
		Demo d = new Demo();
		
		d = (Demo) fa;
	}
	
	
}
