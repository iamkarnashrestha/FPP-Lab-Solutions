package prog13_2.db;

public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private String ssn;

	public Person(String id, String firstName, String lastName, String ssn) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSsn() {
		return ssn;
	}
}
