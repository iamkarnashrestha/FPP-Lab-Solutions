package prog3_2.employeeinfo;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
//changed date to local date;
		hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	
	public void createNewChecking(double startAmount) {
		
	savingsAcct=new Account(this, AccountType.SAVINGS,startAmount);	
	}

	public void createNewSavings(double startAmount) {
	checkingAcct=new Account(this,AccountType.CHECKING,startAmount);
	}
	
	public void createNewRetirement(double startAmount) {
		retirementAcct=new Account(this,AccountType.RETIREMENT,startAmount);
	}

	public String getFormattedAcctInfo() {
		String info="ACCOUNT INFO FOR "+this.name+"\n\n";
		if(this.savingsAcct!=null)
			info+=this.savingsAcct.toString()+"\n";
		if(this.checkingAcct!=null)
			info+=this.checkingAcct.toString()+"\n";
		if(this.retirementAcct!=null)
			info+=this.retirementAcct.toString()+"\n";
		return info+="\n";
	}
	public void deposit(String acctType, double amt){
		if(acctType.equals("SAVINGS"))
		{
			this.savingsAcct.makeDeposit(amt);
		}
		else if(acctType.equals("CHECKING"))
		{
			this.checkingAcct.makeDeposit(amt);
		}
		else if(acctType.equals("RETIREMENT"))
		{
			this.retirementAcct.makeDeposit(amt);
		}			
	}
	
	public boolean withdraw(String acctType, double amt){
		boolean result = false;
		if(acctType.equals("SAVINGS"))
		{
			result= this.savingsAcct.makeWithdrawal(amt);
			
		}
		else if(acctType.equals("CHECKING"))
		{
			result=this.checkingAcct.makeWithdrawal(amt);
		}
		else if(acctType.equals("RETIREMENT"))
		{
			result=this.retirementAcct.makeWithdrawal(amt);
		}	
		
		if(result==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


	public String getName() {
		return name;
	}


	public LocalDate getHireDate() {
		return hireDate;
	}


	
	

}
