package prog5_3;

import java.util.Arrays;

public class MainLambda {
	public static void main(String[] args) {

		StringSort ss = new StringSort(
				(String o1, String o2) -> o1.length() > o2.length() ? 1 : o1.length() < o2.length() ? -1 : 0);

		String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };

		ss.stringSort(testStrings);

		System.out.println(Arrays.toString(testStrings));
	}
}