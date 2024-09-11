package StringComparision;

public class EqualsIgnoreCase {

	public static void main(String[] args) {

		String s1 = "rahul";

		String s2 = "RAHUl";

		System.out.println(s1.equals(s2));// match eeach char

		System.out.println(s1.equalsIgnoreCase(s2));// here it will ignore case either lower or upper
	}
}
