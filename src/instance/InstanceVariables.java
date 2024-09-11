package instance;

class InstanceVariables {		
	//instance variables
	int rollNo=10;
	String name="noor";
	

	//static variables but declare with the varibaled
	static String college="RRIMT";

	//Constructor
	InstanceVariables(int rollNo, String name) {
	rollNo = rollNo;
	name = name;
	}
	void display() {
		System.out.println("rollno"+ "name" +"college");
	}
	
	//Test class to show the values of objects  
	public class TestStaticVariable1{  
	 public static void main(String args[]){  
		 InstanceVariables s1 = new InstanceVariables(111,"Karan");  
		 InstanceVariables s2 = new InstanceVariables(222,"Aryan");  
	 //we can change the college of all objects by the single line of code  
	 //Student.college="BBDIT";  
	 s1.display();  
	 s2.display();  
	 }  
	}  
}
