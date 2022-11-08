package prog4_1;

public class Professor extends DeptEmployee {
	Professor(String name, double salary, int year, int Month, int dayOfMonth) {
		super(name, salary, year, Month, dayOfMonth);

	}

	private int numberOfPublications;

	public int getNumberOfPublications() {
		return numberOfPublications;
	}

	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}
	
	
}
