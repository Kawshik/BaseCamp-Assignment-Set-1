package integrated_question09;

public class UsersList {
	User[] users;
	int i;

	public UsersList() {
		this.users = new User[10];
		this.i = 0;
	}

	public void add(User user) {
		if(i==this.users.length) resize();
		this.users[i] = user;
		i++;
	}

	private void resize() {
		User[] newUsers = new User[this.users.length * 2];
		for (int i = 0; i < this.users.length; i++) {
			newUsers[i] = this.users[i];
		}
		this.users = newUsers;
	}

	public User[] get() {
		User[] users = new User[i];
		for (int i = 0; i < this.users.length; i++) {
			if (this.users[i] != null)
				users[i] = this.users[i];
		}
		return users;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			if (this.users[i] != null)
				System.out.println(this.users[i]);
		}
	}
}
