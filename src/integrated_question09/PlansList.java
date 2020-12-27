package integrated_question09;


public class PlansList {
	Plan[] plans;
	int i;

	public PlansList() {
		this.plans = new Plan[10];
		this.i = 0;
	}

	public void add(Plan plan) {
		if(i==this.plans.length) resize();
		this.plans[i] = plan;
		i++;
	}

	private void resize() {
		Plan[] newPlans = new Plan[this.plans.length * 2];
		for (int i = 0; i < this.plans.length; i++) {
			newPlans[i] = this.plans[i];
		}
		this.plans = newPlans;
	}

	public Plan[] get() {
		Plan[] plans = new Plan[i];
		for (int i = 0; i < this.plans.length; i++) {
			if (this.plans[i] != null)
				plans[i] = this.plans[i];
		}
		return plans;
	}

	public int size() {
		return i;
	}
	
	public void print() {
		for (int i = 0; i < this.i; i++) {
			if (this.plans[i] != null)
				System.out.println(this.plans[i]);
		}
	}
}
