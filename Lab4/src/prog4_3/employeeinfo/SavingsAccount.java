package prog4_3.employeeinfo;

public class SavingsAccount extends Account{
	private final double RATE=0.25;
	SavingsAccount(Employee emp, double balance) {
		super(emp, balance);
		
	}
	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double interest = (RATE/100)*baseBalance;
		super.setBalance(baseBalance + interest);
		return super.getBalance();
		}
	@Override
	public AccountType getAcctType() {
		return AccountType.SAVINGS;
		}





}
