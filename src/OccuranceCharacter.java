
public class OccuranceCharacter {
	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'c', 'a', 'b', 'a', 'c' };
		char searchChar = 'a';
		int count = 0;
		for (char ch : arr) {
			if (ch == searchChar) {
				count++;
			}
		}
		System.out.println(searchChar + " appears " + count + " times in the array.");
	}
}
