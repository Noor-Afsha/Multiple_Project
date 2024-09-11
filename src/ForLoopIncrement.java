import java.util.Scanner;

public class ForLoopIncrement {

	public static void main(String[] args) {
		
//		for(int i=1; i<=10; i++) {
//			System.out.println(i);
//		}
		
//		for(int i=10; i>=0; i--) {
//			System.out.println(i);
//		}
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number");
//		int n=9;
		
	int	n=sc.nextInt();
		for(int i=1; i<=10; i++ ) {
			System.out.println(n+ "x" +i+"="+n*i);
		}
	}
}
