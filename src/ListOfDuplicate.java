
	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;

	public class ListOfDuplicate {
	    public static void main(String[] args) {
	        List<Integer> list = new ArrayList<>();
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        list.add(1);
	        list.add(4);
	        list.add(2);

	        Set<Integer> set = new HashSet<>(list);
	        List<Integer> newList = new ArrayList<>(set);

	        System.out.println("Original List: " + list);
	        System.out.println("List with Duplicates Removed: " + newList);
	    }
	}

