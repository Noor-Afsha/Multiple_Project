package Datatypes;

import java.util.ArrayList;

public class NonPrimitive {
	public static void main(String[] args) {
		
	
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);

//	 Compare the ArrayLists
		if (list1.equals(list2)) {

			System.out.println("The ArrayLists are equal.");
		} else {
			System.out.println("The ArrayLists are not equal.");
		}
	}
}
