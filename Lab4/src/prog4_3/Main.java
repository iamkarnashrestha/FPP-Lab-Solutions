package prog4_3;
import java.util.Scanner;
import prog4_3.employeeinfo.Employee;

public class Main {
	Employee[] emps = null;
	public static void main(String[] args) {
		new Main();
	}
	Main(){
		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		
		
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);	
		
		firstMenu();
		
	}
	

	String getFormattedAccountInfo(){
		String info="";
		for(int i=0;i<emps.length;i++)
		{
			info=info+emps[i].getFormattedAcctInfo();
		}
		return info;
	}
	
	public String findEmployeeNames()
	{
		String employeeNames="";
		for(int i=0;i<emps.length;i++)
		{
			employeeNames+=i+". "+emps[i].getName()+"\n";
		}
		employeeNames+="Select an employee: (type a number)";
		return employeeNames;
	}

	
	public void firstMenu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("A. See a report of all accounts.\nB. Make a deposit \nC. Make a withdrawal.\nMake a selection (A/B/C):"
				);
		String answer = sc.next();
		switch(answer.toUpperCase())
		{
		case "A":
			String info = getFormattedAccountInfo();
			System.out.println(info);
			break;
		case "B":
			makeDepositOrWithdraw(1);
			break;
		case "C":
			makeDepositOrWithdraw(2);
			break;
		}	
	}
	
	public void makeDepositOrWithdraw( int define)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println(findEmployeeNames());
		int index = sc.nextInt();
		MyStringList accList=emps[index].getNamesOfAccounts();
		for(int i=0;i<accList.size();i++)
		{
			System.out.println(i+"."+accList.get(i));
			
		}
		System.out.println("Select an account: (type a number)"); 
		
		int choice = sc.nextInt();
		if(define==1)
		{
			System.out.println("Deposit Amount");
			double amount= sc.nextDouble();
			emps[index].deposit(choice,amount);
			System.out.println("$"+amount+"has been deposited in the"+accList.get(choice)+" account of"+emps[index].getName());
		}
		else if(define == 2)
		{
			System.out.println("Amount to withdraw");
			double amount= sc.nextDouble();
			emps[index].withdraw(choice,amount);
			System.out.println("$"+amount+"has been deducted in the"+accList.get(choice)+" account of"+emps[index].getName());
		}
	
	}
}
