package prog8_3.employeesort;

import java.util.Comparator;
import java.util.Date;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();
		Date hireDate1 = o1.getHireDate();
		Date hireDate2 = o2.getHireDate();
		int salary1 = o1.getSalary();
		int salary2 = o2.getSalary();
		if(salary1 != salary2)
		{
			 if(salary1 < salary2) {
					return -1;
				}
				else {
					return 1;
				}
		}
		
		//salary 1 equals to salary2
		if(name1.compareTo(name2) != 0) {
			return name1.compareTo(name2);
		}
		//now name1 equals name2
		
			return hireDate1.compareTo(hireDate2);
	
		
		
		//now name1 equals name2 and hireDate1 equals hireDate2
       
	

}
}