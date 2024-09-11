import java.util.Scanner;

public class YoungorNot {

	public static void main(String[] args) {
		
		int age;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the age..");
		age=sc.nextInt();
		
		if(age>=18 && age<=55) {
			System.out.println("young person");
		}
		
		else if(age>55){
			System.out.println("person is old");
		}
		else {
			System.out.println("person is under age1");
		}
	}
}
