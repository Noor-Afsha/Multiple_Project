package Exceptation;

//arithmatic exception

public class ClassA {
public static void main(String[] args) {
	try {
		int data=10/0;
	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("rest of the code");
}
}
