import java.util.Arrays;

public class SecondMaxSalary {
	public static void main(String[] args) {
		int[] salaries = { 50000, 25000, 75000, 40000, 60000 };
		Arrays.sort(salaries);
		int secondMaxSalary = salaries[salaries.length - 2];
		System.out.println("The second maximum salary is: " + secondMaxSalary);
	}
}
