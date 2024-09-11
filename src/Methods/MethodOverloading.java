package Methods;

public class MethodOverloading {

	void add(int a, long b) {
		System.out.println(a + b);
	}

	void add(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static void main(String[] args) {
		MethodOverloading m = new MethodOverloading();

		m.add(11, 10);
		m.add(1, 10, 20);
	}
}
