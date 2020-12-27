package integrated_question09;

public class User {
	String name;
	String userId;
	String phoneNumber;
	String street;
	String city;
	String state;
	String country;
	Plan internetPlan;

	public User(String name, String userId, String phoneNumber, String street, String city, String state,
			String country, Plan internetPlan) {
		super();
		this.name = name;
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.internetPlan = internetPlan;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public Plan getInternetPlan() {
		return internetPlan;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setInternetPlan(Plan internetPlan) {
		this.internetPlan = internetPlan;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", UserId=" + userId + ", phoneNumber=" + phoneNumber + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", internetPlan=" + internetPlan
				+ "]";
	}

}
