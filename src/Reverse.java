
public class Reverse {
	public static void main(String[] args) {
		String str = "Noor Afsha";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String reversedStr = sb.toString();
		System.out.println(reversedStr);
	}
}
