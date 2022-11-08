package prog4_6.case3;

import java.util.GregorianCalendar;

public class PersonWithJob {
	private double salary;
	Person person;
	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		person=new Person(name, dob);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public String getName() {
		return person.getName();
	}
	public GregorianCalendar getDateOfBirth() {
		return person.getDateOfBirth();
	}
	
	//Can use either same classes or instanceof strategy here
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(getClass() != ob.getClass()) return false;
		PersonWithJob p = (PersonWithJob)ob;
		return p.person.equals(person) && p.salary == salary;
	}
}
