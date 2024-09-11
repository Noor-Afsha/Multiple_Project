import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListProgram {
public static void main(String[] args) {
	List<String> al=new ArrayList<String>();
	//adding the string in the list
	al.add("mona");
	al.add("stakshi");
	al.add("stakshi");
	al.add("stakshi");
	al.add("stakshi");

	
	//accessing the element from list
	System.out.println("returning the element: "+ al.get(1));
	
	//setting the value in existing list
	
	al.set(1, "naina");
	
	//sorting the list
	Collections.sort(al);
	
	//using for each loop
	for(String name:al) {
		System.out.println();
		System.out.println("print the array list: "+name);
		
	}
//	System.out.println();
//	System.out.println("print the array list: "+al);
	
}
}
