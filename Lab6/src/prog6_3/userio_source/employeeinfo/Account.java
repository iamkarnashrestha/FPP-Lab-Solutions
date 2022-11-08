package prog6_3.userio_source.employeeinfo;

class Account {
//public final static String CHECKING = "checking";
//public final static String SAVINGS = "savings";
//public final static String RETIREMENT = "retirement";
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;
	public Account(Employee emp,  AccountType savings, double balance){
	employee = emp;
	this.acctType =savings;
	this.balance = balance;
	}
	
	Account(Employee emp, AccountType acctType){
	this(emp,acctType,DEFAULT_BALANCE);
	}
		
	public String toString() {
	return "Account type: " + acctType+"\n"+ "Current bal: " + balance;
	}
	public void makeDeposit(double deposit) {
	//implement
		this.balance+=deposit;
		
	}
	public boolean makeWithdrawal(double amount)
	{
		if(this.balance<amount)
		{
			return false;
		}
		else
		{
			this.balance-=amount;
			return true;
		}
	}
	public double getBalance() {
		return balance;
	}
	
	public AccountType getAcctType() {
		return acctType;
	}


}

