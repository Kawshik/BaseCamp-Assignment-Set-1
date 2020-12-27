package integrated_question03;

public class HouseList {
	House[] houses;
	int i;
	
	public HouseList() {
		this.houses = new House[10];
		this.i = 0;
	}
		
	public void add(House house) {
		if(i==houses.length) resize();
		
		houses[i] = house;
		i++;
	}
	
	void resize() {
		House[] newHouse = new House[houses.length * 2];
		for (int i = 0; i < houses.length; i++) {
			newHouse[i] = houses[i];
		}
		houses = newHouse;
	}
	
	public House[] get() {
		House[] newHouses = new House[i];
		
		for (int i = 0; i < houses.length; i++) {
			if(houses[i]!=null) newHouses[i] = houses[i];
		}
		
		return newHouses;
	}
	
	public int size() {
		return i;
	}
}
