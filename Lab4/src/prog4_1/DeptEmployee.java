package prog4_1;

import java.time.LocalDate;

public class DeptEmployee {
	String name;
	double salary;
	LocalDate hireDate;
	
	DeptEmployee(String name,double salary, int year, int Month,int dayOfMonth)
	{
		this.name=name;
		this.salary=salary;
		hireDate=LocalDate.of(year, Month, dayOfMonth);
	}
	public double computeSalary()
	{
		return this.salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
}
