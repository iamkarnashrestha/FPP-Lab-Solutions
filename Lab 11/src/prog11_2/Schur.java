package prog11_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Schur {
	
	boolean checkForSum(List<Integer> list,Integer z)
	{
		Set<Integer> intInOrder = new HashSet<>();
		for(Integer s: list) {
			intInOrder.add(s);
		}
		
		for (Integer s : intInOrder) {
			int find = z - s; //(z - s > 0) ? z - s : z;
			if (intInOrder.contains(find)) {
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args)
	{
		Schur s = new Schur();
		List<Integer> input = new ArrayList<>();
		input.add(10);
		input.add(3);
		input.add(4);
	
		System.out.println(s.checkForSum(input, 7));
		System.out.println(s.checkForSum(input, 12));
	}
}
