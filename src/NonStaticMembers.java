
public class NonStaticMembers {

	int a = 10;// non static variables

	void next() {// non static method
		a++;
		System.out.println("hii " + a);
	}

	public static void main(String[] args) {

		NonStaticMembers m = new NonStaticMembers();// creating instance of object of class name

		int b = m.a;// calling non static variable

		m.next();// calling non static method
		m.next();
		m.next();

		NonStaticClassA n = new NonStaticClassA();
		n.best();
		n.best();
	}
}
