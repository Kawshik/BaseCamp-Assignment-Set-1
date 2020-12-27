package integrated_question03;

public class House {
	String type;
	String rooms;
	String status;

	public House(String type, String rooms, String status) {
		this.type = type;
		this.rooms = rooms;
		this.status = status;
	}

	public House() {
		
	}

	public String getType() {
		return type;
	}

	public String getRooms() {
		return rooms;
	}

	public String getStatus() {
		return status;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "House [type=" + type + ", rooms=" + rooms + ", status=" + status + "]";
	}

}
