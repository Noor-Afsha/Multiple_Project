package StringComparision;

public class ByUsingEqualsMethod {

	public static void main(String[] args) {

		String s1 = "noor";// literal string

		char[] ch = { 'n', 'o', 'o', 'r' };// converting char to string

		String s2 = new String(ch);

		String s3 = new String("noor");// using new keyword

		String s4 = "afsha";

		System.out.println(s1.equals(s2));

		System.out.println(s1.equals(s3));

		System.out.println(s1.equals(s4));
	}
}
