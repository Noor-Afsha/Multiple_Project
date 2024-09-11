package StringAllMethods;

public class StringCharAtMethod {

	public static void main(String[] args) {
//example 01
		String s = "java";

		char ch = s.charAt(3);// returning 3index value of string

		System.out.println(ch);

// example 02

//to overcome from this charAt() we use   int strLength = str.length();  
//directly we can fetch nth index of string
		String name = "Mona";

		char c = name.charAt(2);
		char c1 = name.charAt(0);
		char c2 = name.charAt(3);

		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);

// throw exception bcoz string length is greater thn so exception will be
// indexOutOfBound
		String s1 = "Python";

		char ch1 = s1.charAt(6);

		System.out.println("value of ch1:-" + ch1);

	}
}
