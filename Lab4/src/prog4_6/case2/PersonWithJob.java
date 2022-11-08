package prog4_6.case2;

import java.util.GregorianCalendar;

public final class PersonWithJob {
	private double salary;
	private Person per;
	public PersonWithJob(String name, GregorianCalendar dob, double salary) {
		per=new Person(name,dob);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass()!=this.getClass()) return false;
		PersonWithJob p = (PersonWithJob)ob;
		return p.per.equals(per) && p.getSalary()==this.getSalary();
	}
}
