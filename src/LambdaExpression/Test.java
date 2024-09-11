package LambdaExpression;

import java.util.function.Function;

public class Test {

//	public static int square(int n) {
//		return n * n;
//	}

	public static void main(String[] args) {
//by using lambda expression
		Function<Integer, Integer> f = i -> i * i;
		System.out.println("print the square of 5:" + f.apply(5));
		System.out.println("print the square of 55:" + f.apply(55));
	}
}
