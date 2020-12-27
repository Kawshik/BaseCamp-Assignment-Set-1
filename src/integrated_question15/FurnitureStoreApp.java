package integrated_question15;

import java.util.Scanner;

public class FurnitureStoreApp {
//	tables, chairs, beds, desks, backpacks, dressers, and cupboards
	
	ItemsList items;
	static Scanner sc;

	public FurnitureStoreApp() {
		items = new ItemsList();
	}

	public void printItems(Item[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}
	
	Item[] sortItemsByCategory(){
		Item[] items = this.items.get();
		
		for (int i = 1; i < items.length; i++) {
			int j = i-1;
			Item key = items[i];
			while(j>=0 && items[j].getCategory().compareTo(key.getCategory()) > 0) {
				items[j+1] = items[j];
				j--;
			}
			items[j+1] = key;
		}
		
		return items;
	}
	
	Item[] sortItemsByPrice(){
		Item[] items = this.items.get();
		
		for (int i = 1; i < items.length; i++) {
			int j = i-1;
			Item key = items[i];
			while(j>=0 && items[j].getPrice() > key.getPrice()) {
				items[j+1] = items[j];
				j--;
			}
			items[j+1] = key;
		}
		
		return items;
	}
	
	void printItemsByCategory(Item[] sortedItems) {
		String category = sortedItems[0].getCategory();
		System.out.println(category);
		for (int i = 0; i < sortedItems.length; i++) {
			if (sortedItems[i].getCategory().equals(category)) {
				System.out.println(sortedItems[i]);
			} else {
				category = sortedItems[i].getCategory();
				System.out.println(category);
				System.out.println(sortedItems[i]);
			}
		}
	}
	
	void showItemsByCategory(){
		Map map = new Map();
		Item[] items = this.items.get();
		for (int i = 0; i < items.length; i++) {
			if(map.contains(items[i].getCategory())) {
				ItemsList oldItems = map.getValue(items[i].getCategory());
				oldItems.add(items[i]);
				map.update(items[i].getCategory(), oldItems);
			} else {
				ItemsList newItems = new ItemsList();
				newItems.add(items[i]);
				map.add(items[i].getCategory(),newItems);
			}
		}
		
		printMap(map);
	}
	
	void printMap(Map map) {
		Node[] n = map.getNodes();
		for (int i = 0; i < n.length; i++) {
			System.out.println("Category: " + n[i].getKey());
			Item[] items = n[i].getValue().get();
			printItems(items);
		}
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		FurnitureStoreApp fsa = new FurnitureStoreApp();
		fsa.addSampleData();
//		fsa.printItemsByCategory(fsa.sortItemsByCategory());
		fsa.showItemsByCategory();
		
	}
	
	void addSampleData() {
		this.items.add(new Item("blue Sofa", 10000, "Sofa"));
		this.items.add(new Item("brown Sofa", 10000, "Sofa"));
		this.items.add(new Item("Dining Table", 10000, "Table"));
		this.items.add(new Item("King Size Bed", 10000, "Bed"));
		this.items.add(new Item("Hermen Millar Gamming Chair", 10000, "Chairs"));
		this.items.add(new Item("Leather Couch", 10000, "Sofa"));
		this.items.add(new Item("Ikea Table Top", 10000, "Table"));
	}
}