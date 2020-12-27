package integrated_question04;

class Node {
	private String key;
	private int value;

	public Node(String key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

public class Map {
	private Node[] nodes;
	private int i;
	
	public Map() {
		this.nodes = new Node[10];
		this.i = 0;
	}

	Node[] getNodes(){
		Node[] nodes = new Node[i];
		for (int i = 0; i < this.i; i++) {
			nodes[i] = this.nodes[i];
		}
		return nodes;
	}
	
	void add(String key) {
		if(this.i==this.nodes.length) resize();
		this.nodes[i] = new Node(key, 1);
		this.i++;
	}
	
	void resize() {
		Node[] newNodes = new Node[this.nodes.length * 2];
		for (int i = 0; i < this.i; i++) {
			newNodes[i] = this.nodes[i];
		}
		this.nodes = newNodes;
	}
	
	int getValue(String key) {
		int value = 0;
		for (int i = 0; i < this.i; i++) {
			if(nodes[i].getKey().equals(key))
				value = nodes[i].getValue();
		}
		return value;
	}
	
	boolean contains(String key) {
		for (int i = 0; i < this.i; i++) {
			if(nodes[i]!=null)
				if(nodes[i].getKey().equals(key))
					return true;
		}
		return false;
	}
	
	void update(String key, int value) {
		for (int i = 0; i < this.i; i++) {
			if(nodes[i].getKey().equals(key)) {
				nodes[i].setValue(value);
			}
		}
	}
}
