public class MethodOverloading {

	public static int add(int num1, int num2) {
		return num1 + num2;
	}

	public int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}

	public double add(double num1, double num2) {
		return num1 + num2;
	}

	public static void main(String[] args) {
		
		MethodOverloading md = new MethodOverloading();
		
		System.out.println("first method " + md.add(2, 3));
		
		System.out.println("second method "+md.add(2, 10, 20));
		
		System.out.println("third method "+ md.add(10.90, 12.90));

//		md.add(2,2);
//		md.add(19, 22, 99) ; 
//		md.add(2.3, 10.44);
	}
}
