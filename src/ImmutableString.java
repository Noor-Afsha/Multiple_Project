public class ImmutableString {
//immutable means it can not modified it is unchangeable

	public static void main(String[] args) {

		String s = new String("Noori");

		// s.concat("xyz");// concat() method appends the string at the end

		s = s.concat(" xyz");// it will print both string

		System.out.println(s);
	}

}
