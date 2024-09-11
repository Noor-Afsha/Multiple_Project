package StringConcanitation;

public class StringFormat {

	public static void main(String[] args) {

		String s1 = new String("noor");

		String s2 = new String("afsha");
		String s3=new String("Rizwan");

		// String s = String.format("%s %s", s1, s2);

		String s = String.join(" ", s1,s2, s3);

		System.out.println(s.toString());
	}
}
