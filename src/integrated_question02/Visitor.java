package integrated_question02;

public class Visitor {
	String name;
	int age;
	String gender;
	int fee;

	public Visitor(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fee = 0;
	}

	public Visitor() {

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public int getFee() {
		return fee;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Visitor [name=" + name + ", age=" + age + ", gender=" + gender + ", fee=" + fee + "]";
	}

}
