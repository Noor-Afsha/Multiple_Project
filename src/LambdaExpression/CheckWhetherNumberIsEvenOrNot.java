package LambdaExpression;

import java.util.function.Predicate;

public class CheckWhetherNumberIsEvenOrNot {

	public static void main(String[] args) {

		Predicate<Integer> f = i -> i % 2 == 0;
		System.out.println("Check the number is even r odd:-" + f.test(5));
	}
}
