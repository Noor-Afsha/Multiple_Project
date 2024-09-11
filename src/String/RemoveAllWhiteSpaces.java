package String;

public class RemoveAllWhiteSpaces {
public static void main(String[] args) {
	String a="    ja   va     st    a   r";
	String b=a.replaceAll("\\s","");
	System.out.println(b);
	
}
}
