package prog4_3.employeeinfo;

class Account {

	
	private double balance;
	private Employee employee;
	private AccountType accType;
	Account(Employee emp,double balance){
	employee = emp;
	this.balance = balance;
	}

	public String toString() {
	return "Current bal: " + balance;
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
		return accType;
		}

	public void setBalance(double updatedBalance) {
		this.balance=updatedBalance;
		
	}
	
	



}

