package prog4_3.employeeinfo;

import java.time.LocalDate;

import prog4_3.MyStringList;

public class Employee {

	private AccountList accounts=new AccountList();
	private String name;
	private LocalDate hireDate;
	
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
//changed date to local date;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	
	public void createNewChecking(double startAmount) {

	
		Account acct = new CheckingAccount(this,startAmount);
		accounts.add(acct);
			
	}

	public void createNewSavings(double startAmount) {
		
		Account acct = new SavingsAccount(this,startAmount);
		accounts.add(acct);
	}
	
	public void createNewRetirement(double startAmount) {
	
		Account acct = new RetirementAccount(this,startAmount);
		accounts.add(acct);
	}

	public String getFormattedAcctInfo() {
	String info="\n\nACCOUNT INFO FOR "+this.name+"\n";
		for(int i=0;i<accounts.size();i++)
		{
			info+="\nAccount Type:"+accounts.get(i).getAcctType()+" ";
			info+="Current Bal: "+accounts.get(i).getBalance();			
		}
		return info;
	}
	
	public void deposit(int acctIndex, double amt){
		
		Account selected = accounts.get(acctIndex);
		selected.makeDeposit(amt);
	}
	
	public boolean withdraw(int acctIndex, double amt){
		Account selected = accounts.get(acctIndex);
		if(selected.makeWithdrawal(amt))
			return true;
		else
			 return false;
		
	}

	public String getName() {
		return name;
	}


	public LocalDate getHireDate() {
		return hireDate;
	}

	
	public MyStringList getNamesOfAccounts() {
	MyStringList namesOfAccounts=new MyStringList();
	for(int i=0;i<this.accounts.size();i++)
	{
		
	 namesOfAccounts.add(accounts.get(i).getAcctType().toString());
	
	}
	return namesOfAccounts;
	
	}
	
	
	}

