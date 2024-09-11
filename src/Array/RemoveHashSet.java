package Array;

import java.util.HashSet;

public class RemoveHashSet {
public static void main(String[] args) {
	HashSet<String> set=new HashSet<>();
    set.add("Ravi");  
    set.add("Vijay");  
    set.add("Arun");  
    set.add("Sumit");  
    set.add("swati");
    
    System.out.println("print the list of hashset: "+set);
    
    //remve specific element from hashset
    
    set.remove("Ravi");
    System.out.println("Afetr remving the specific element from hashset: "+ set);
}
}
