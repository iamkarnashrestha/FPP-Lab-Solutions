package prog4_3.employeeinfo;

public class CheckingAccount extends Account{
	
	CheckingAccount(Employee emp, double balance) {
		super(emp, balance);
		
	}
	@Override
	public AccountType getAcctType() {
		return AccountType.CHECKING;
		}

	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double updatedBalance= baseBalance - 5;
		super.setBalance(updatedBalance);
		return super.getBalance();
	}

	

	
	
}
