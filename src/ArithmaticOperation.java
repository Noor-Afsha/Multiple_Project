import java.util.Scanner;

public class ArithmaticOperation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the two number");

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println("Enter your option");

		sc.nextLine();

		String option = sc.nextLine();

		switch (option) {

		case "Add":
			System.out.println("add " + (a + b));
			break;

		case "Sub":
			System.out.println("sub " + (a - b));
			break;

		case "Multiply":
			System.out.println("mul " + (a * b));
			break;

		case "Div":
			System.out.println("divide" + (a / b));
			break;

		default:
			System.out.println("Invalid operations");

		}
	}
}
