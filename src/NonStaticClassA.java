
public class NonStaticClassA {
	int b = 13;

	void best() {
		b++;
		System.out.println("calling classA of non static " + b);
	}

	public static void main(String[] args) {

		NonStaticClassA nA = new NonStaticClassA();// creating instance of object with class name

		int c = nA.b;// accessing the non static variables

		nA.best();// accessing the non static method
	}
}
