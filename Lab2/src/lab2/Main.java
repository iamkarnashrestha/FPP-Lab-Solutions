package lab2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address add1A = new Address("10 Adams", "Chicago", "IA", "52556");
		Address add1B = new Address("110 Burlington", "Fairfield", "IA", "52556");
		Address add2A = new Address("322 Harrison", "Chicago", "IA", "52556");
		Address add2B = new Address("2210 Burlington", "Fairfield", "IA", "52556");
		
		Customer c1 = new Customer("Karna", "Shrestha","123456",add1A,add1B);
		Customer c2 = new Customer("Pukar", "Subedi","123456",add2A,add2B);
		
		//Creates an Customer array of length 2
		Customer[] customerArray = new Customer[2];
		customerArray[0] = c1;
		customerArray[1] = c2;
		
		
			for(int i = 0; i < customerArray.length; ++i) {
				Address bAddress = customerArray[i].getBillingAddress();
				String city=bAddress.getCity();
				if(city.equals("Chicago")) {
					System.out.println("Found the Customer! " + customerArray[i].toString());
				}
			}
		
		

	}

}
