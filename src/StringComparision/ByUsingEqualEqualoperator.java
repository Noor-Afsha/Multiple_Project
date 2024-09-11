package StringComparision;

public class ByUsingEqualEqualoperator {

	public static void main(String[] args) {

//by using == operator it matches only the reference like s1 and s2 not value and new created object
		String s1 = "Noor";

		String s2 = "Noor";

		String s3 = new String("Noor");

		char[] ch = { 'N', 'o', 'o', 'r' };

		String s4 = new String(ch);

		System.out.println(s1 == s2);

		System.out.println(s1 == s3);

		System.out.println(s1 == s4);
	}
}
