package Array;

import java.util.HashMap;
import java.util.Map;

public class HashMap12 {

	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

	
		hm.put(1, "Mango"); // Put elements in Map
		hm.put(2, "Apple");
		hm.put(3, "Banana");
		hm.put(4, "Noor");

//		System.out.println(hm);
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());

		}
	}
}
