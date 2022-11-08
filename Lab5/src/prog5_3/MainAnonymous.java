package prog5_3;

import java.util.Arrays;
import java.util.Comparator;


public class MainAnonymous {

	public static void main(String[] args) {
		StringSort ss=new StringSort(new Comparator<String>() {
			public int compare(String o1, String o2) {
			if(o1.length() < o2.length()) return -1;
			else if(o1.length() > o2.length()) return 1;
			else return 0;
			
			}
		});
		
		String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };					
		ss.stringSort(testStrings);
		System.out.println(Arrays.asList(testStrings));

	}

}
