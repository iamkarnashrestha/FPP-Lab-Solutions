package prog4_1;

public class Secretary extends DeptEmployee {
	private double overtimeHours;
	Secretary(String name, double salary, int year, int Month, int dayOfMonth) {
		super(name, salary, year, Month, dayOfMonth);
		
		
		
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

	public double computeSalary()
	{	
		double baseSalary=super.computeSalary();
		return baseSalary+(12*overtimeHours);
	}

	
}
