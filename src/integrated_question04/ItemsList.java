package integrated_question04;

public class ItemsList {
	Item[] items;
	int i;

	public ItemsList() {
		this.items = new Item[10];
		this.i = 0;
	}

	public void add(Item items) {
		if(i==this.items.length) resize();
		this.items[i] = items;
		i++;
	}

	private void resize() {
		Item[] newItems = new Item[this.items.length * 2];
		for (int i = 0; i < this.items.length; i++) {
			newItems[i] = this.items[i];
		}
		this.items = newItems;
	}

	public Item[] get() {
		Item[] items = new Item[i];
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null)
				items[i] = this.items[i];
		}
		return items;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			System.out.println(items[i]);
		}
	}
}
