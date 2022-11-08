package prog3_1;

class Account {
//public final static String CHECKING = "checking";
//public final static String SAVINGS = "savings";
//public final static String RETIREMENT = "retirement";
private final static double DEFAULT_BALANCE = 0.0;
private double balance;
private AccountType acctType;
private Employee employee;
Account(Employee emp, AccountType acctType, double balance){
employee = emp;
this.acctType =acctType;
this.balance = balance;
}
Account(Employee emp, AccountType acctType){
this(emp,acctType,DEFAULT_BALANCE);
}
public String toString() {
return "type = " + acctType + ", balance = " + balance;
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

