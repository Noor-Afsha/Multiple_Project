import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		
		int m1,m2,m3;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("print the average marks of 3 subject");
		
		m1=sc.nextInt();
		m2=sc.nextInt();
		m3=sc.nextInt();
		
		float ave=((float)(m1+m2+m3)/3);
		if(ave>=70) {
			System.out.println("Grade A");
		}
		else if(ave<=60 && ave<70) {
			System.out.println("grade B");
		}
		else if(ave<=50 && ave<60) {
			System.out.println("print C");
		}
		else if(ave<=40 && ave<50) {
			System.out.println("print D");
		}
		else if(ave<40){
			System.out.println("fail");
		
		}
	}
}
