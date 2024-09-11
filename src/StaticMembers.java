
public class StaticMembers {

	public static void main(String[] args) {

		int b = StaticMembers.a;// calling variable

		StaticMembers.m1();// calling method
		StaticMembers.m1();
		StaticMembers.m1();
		StaticMembers.m1();
		m1();
		m1();

		System.out.println(" " + a);

		Array.test();
		System.out.println(Array.i);
	}

	static int a = 10;// static variable

	public static void m1() {// static method
		a++;

	}
}
