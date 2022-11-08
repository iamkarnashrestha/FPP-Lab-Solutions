package prog7_3;

import java.util.LinkedList;

/**
 * Recursively merges two sorted linked lists
 *
 */
public class Merge {
	LinkedList<Integer> newList = new LinkedList<Integer>();
	public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		//implement
		
		if(list1==null || list2==null) return null;
		if (list1.isEmpty()) {
			newList.addAll(list2);
			return newList;
			
		}
		if (list2.isEmpty()) {
			newList.addAll(list1);
			return newList;}
		if(list1.getFirst() < list2.getFirst()) {
			newList.addLast(list1.removeFirst());
			
		}
		else {
			newList.addLast(list2.removeFirst());}
			return merge(list1,list2);
	}
	//test your code
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list1.add(4);list1.add(5);list1.add(21);list1.add(25);
		list2.add(2);list2.add(9);list2.add(17);
		Merge m = new Merge();
		LinkedList list3 = m.merge(list1, list2);
		if(list3 != null) System.out.println(list3);
		
	}
}
