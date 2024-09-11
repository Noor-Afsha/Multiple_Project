package String;

public class Swap {

	public static void main(String args[]) {
		
		String a="HELLO";
		String b="WORLD";
			
		a=a+b;
		
		b=a.substring(0,a.length()-b.length());
		
		a = a.substring(b.length()); //swaping
		
		System.out.println("print the string after swap: a " +a + " and b ="+ b);
		
	}
}
