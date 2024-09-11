
public class InterviewQuest {

	public static void main(String[] args) {
		int a=0, b=1, num=50, x=0,count=0;
		while(count<=num) {
			count=a+b;
			a=b;
			b=count;
			x++;
		}
		System.out.println(count);
	}
}
