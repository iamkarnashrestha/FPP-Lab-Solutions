package prog6_3.userio_source;


import prog6_3.userio_source.employeeinfo.Employee;

public class Main {
	public static Employee[] emps = null;
	public static void main(String[] args) {
		new Main();
	}
	public Main(){
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
		
				
//		UserIO userIo = new UserIO();
//		userIo.setVisible(true);
//		Scanner sc = new Scanner(System.in);
//		System.out.print("See a report of all account balances? (y/n) ");
//		String answer = sc.next();
//		if(answer.equalsIgnoreCase("y")){
//			String info = getFormattedAccountInfo();
//			System.out.println(info);
//		}
//		else {
//			//do nothing..the application ends here
//		}	

		
	}
	public  String getFormattedAccountInfo(){
		String info="";
		for(int i=0;i<emps.length;i++)
		{
			info=info+emps[i].getFormattedAcctInfo();
		}
		return info;
	}
}
