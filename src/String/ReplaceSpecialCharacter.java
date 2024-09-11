package String;

public class ReplaceSpecialCharacter {
public static void main(String[] args) {
	
	String a="<><??ja.,wa@st+ar%&*";
	String str=a.replaceAll("[^a-zA-Z0-9-*]", "");
	System.out.println(str);
}
}
