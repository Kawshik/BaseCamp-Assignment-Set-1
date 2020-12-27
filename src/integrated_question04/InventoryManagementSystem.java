package integrated_question04;

public class InventoryManagementSystem extends SuperMarketApp{
	private ItemsList il;

	public InventoryManagementSystem() {
		il = new ItemsList();
		init();
	}

	private void init() {
		il.add(new Item("1001", 100, 0));
		il.add(new Item("1002", 10, 0));
		il.add(new Item("1003", 400, 50));
		il.add(new Item("1004", 200, 5));
		il.add(new Item("1005", 150, 10));
		il.add(new Item("1006", 103, 2));
	}
	
	public Item getItem(String id){
		Item[] items = il.get();
		for (int i = 0; i < items.length; i++) {
			if(items[i].getId().equals(id))
				return items[i];
		}
			
		return null;
	}
	
	public ItemsList mostSoldItemTillDate(){
		ItemsList mostSold = new ItemsList();
		
//		get customers list
		Customer[] customers = cms.getCustomers().get();
//		Create Map
		Map map = new Map();
//		get each item bought by a customer 
		for (int i = 0; i < customers.length; i++) {
			Bill[] bills = customers[i].getBills().get();
			for (int j = 0; j < bills.length; j++) {
				Item[] items = bills[j].getItems().get();
				for (int k = 0; k < items.length; k++) {
//					keep putting and updating the map
					String key = items[k].getId();
					if(map.contains(key)) {
						map.update(key, map.getValue(key) + 1);
					} else {
						map.add(key);
					}
				}
			}
		}

//		traverse the map to get the most
		Node[] nodes = map.getNodes();
//		return the item having highest value in map
		int maxQuantity = 0;
		String maxItem = "";
		
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i].getValue()>maxQuantity) {
				maxQuantity = nodes[i].getValue();
				maxItem = nodes[i].getKey();
			}
		}
		
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i].getValue() == maxQuantity)
				mostSold.add(getItem(maxItem));
		}
	
		return mostSold;
	}
}
