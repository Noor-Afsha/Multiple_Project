package String;

public class ReverseOfString {
	public static void main(String[] args) {
		
	//1st approach
	String a="HELLO";
	char[] chArr=a.toCharArray();
	for(int i=chArr.length -1; i>=0 ; i--) {
		System.out.println(chArr[i]);
		
	}
	System.out.println("");
	
	//2nd approach
	StringBuffer sb=new StringBuffer(a);
	System.out.print(sb.reverse());
	
	System.out.println("");
	//3rd approach
	StringBuilder sb1=new StringBuilder(a);
	System.out.println(sb1.reverse());
	
	System.out.println("");
	
	//4th approach
	for(int i=a.length() -1; i>0; i--) {
		System.out.println(a.charAt(i));
	}
}
}