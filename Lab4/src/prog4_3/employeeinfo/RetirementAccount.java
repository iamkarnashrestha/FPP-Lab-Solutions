package prog4_3.employeeinfo;

public class RetirementAccount extends Account{

	RetirementAccount(Employee emp, double balance) {
		super(emp, balance);
	}
	@Override
	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
		}
	
	public boolean makeWithdrawal(double amount)
	{	
		double baseBalance=super.getBalance();
		double penalty=0.02*baseBalance;
		
		if(baseBalance<amount+penalty)
		{
			return false;
		}
		else
		{
			super.makeWithdrawal(amount+penalty);
			return true;
		}
	}

}
