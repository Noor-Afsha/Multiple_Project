package Array;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetlll {
public static void main(String[] args) {
	
	HashSet<String> hs=new HashSet<String>();
	hs.add("noor");
	hs.add("noor");
	hs.add("noor");
	hs.add("nuti");
	
//	System.out.println(hs);
	Iterator<String> i=hs.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
}
}
