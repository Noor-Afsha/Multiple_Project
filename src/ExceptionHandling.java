
public class ExceptionHandling {

	public static void main(String[] args) {
// program without exception handling
//        System.out.println("main method executed");
//
//        int a = 10, b = 0, c;
//
//        c = a / b;
//
//        System.out.println("main method ended");
//    }

		// program using exception handling

		System.out.println("main methd executed");

//		int a = 10, b = 0, c;

		try {
			int a = 10, b = 0, c;

			c = a / b;

			System.out.println("operation success");

		} catch (ArithmeticException e) {

			e.printStackTrace();

			System.out.println("a cann't divided by b because b's value is zero");
		}
	}
}
