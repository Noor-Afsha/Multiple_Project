package String;

public class RemoveDuplicateString {
	public static void main(String[] args) {
		String a = "programming";
		StringBuilder sb = new StringBuilder();
		sb.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(a);
	}
}
