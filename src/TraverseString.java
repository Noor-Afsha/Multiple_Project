
public class TraverseString {
	public static void main(String[] args) {
		
		String s = "noor noor noor noor noor ";
        String[] arr = s.split(" ");
        int count = 0;
        for (String str : arr) {
            if (str.equals("noor")) {
                count++;
            }
        }
        System.out.println("The substring 'noor' appears " + count + " times in the string.");
    }
	}


