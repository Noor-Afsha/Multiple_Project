package LambdaExpression;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(123);
		al.add(89);

		al.forEach((alist) -> {
			System.out.println(alist);
		});

	}

}
