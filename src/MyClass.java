
public class MyClass implements MyInterface{
	static String s;
	
	public static void main(String[] args) {
		
		MyClass t=new MyClass();
		if(t instanceof MyInterface) {
			System.out.println("i am true interface");
		}
		else {
			System.out.println("I am false interface");
		}
		if(s  instanceof String) {
			System.out.println("i am true String");
		}
		else {
			System.out.println("i am false String");
		}
	}

}
