
public class Constructor {

	int x;

	public Constructor(int y) {
		x = y;
	}

	public static void main(String[] args) {
		Constructor myObj = new Constructor(5);
		System.out.println(myObj.x);
	}
}
