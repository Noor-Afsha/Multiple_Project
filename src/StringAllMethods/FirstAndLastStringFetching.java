package StringAllMethods;

public class FirstAndLastStringFetching {

	public static void main(String[] args) {

		// example 03
		String str = "welcome to wecodee innovation pvt ltd";

		int strLength = str.length();

		// Fetching first character
		System.out.println("character at 0th index:-- " + str.charAt(0));

		// The last Character is present at the string length-1 index
		System.out.println("character at last index:-- " + str.charAt(strLength - 1));

	}

}
