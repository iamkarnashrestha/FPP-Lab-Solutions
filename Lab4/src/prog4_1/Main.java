package prog4_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor p1= new Professor("Arjun Subedi",10,2020,12,12);
		Professor p2= new Professor("Pukar Subedi",10,2020,12,12);
		Professor p3= new Professor("Lovely Khanal",10,2020,12,12);
		
		Secretary s1=new Secretary("Ujjwal Humagain",10,2020,12,20);
		Secretary s2=new Secretary("Madhav Thapa",10,2020,12,20);
		
		p1.setNumberOfPublications(10);
		p2.setNumberOfPublications(10);
		p3.setNumberOfPublications(10);
		
		s1.setOvertimeHours(200);
		s2.setOvertimeHours(200);
		
		DeptEmployee[] department = new DeptEmployee[5];
		department[0]=p1;
		department[1]=p2;
		department[2]=p3;
		department[3]=s1;
		department[4]=s2;
		
		double sumOfSalaries=0.0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you want sum of all salaries? (y/n) ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("y")){
			for(DeptEmployee emp: department)
			{
				sumOfSalaries+= emp.computeSalary();
			}
			System.out.println("Sum of salary of all Employees:"+sumOfSalaries);
			
		}
		sc.close();
		
		

	}

}
