package prog13_2.db;

public class Address {
	private String addrid;
	private Person person;
	private String street;
	private String city;
	private String state;
	private String zip;

	public Address(String addrid, Person person, String street, String city, String state, String zip) {
		this.addrid = addrid;
		this.person = person;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getAddrid() {
		return addrid;
	}
	
	public Person getPerson() {
		return person;
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
	
	public String getZip() {
		return zip;
	}
}
