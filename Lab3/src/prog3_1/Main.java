package prog3_1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee("Bob", "Bob", 100000, 1999, 5, 5);
		Account savingsAccount=new Account(employee,AccountType.SAVINGS,300);
		Account checkingAccount=new Account(employee,AccountType.CHECKING,300);
		Account retirementAccount=new Account(employee,AccountType.RETIREMENT,300);
		System.out.println(savingsAccount.toString());
		System.out.println(checkingAccount.toString());
		System.out.println(retirementAccount.toString());
		

		
		
		
	}

}
