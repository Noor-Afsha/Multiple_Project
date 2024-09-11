package com.example.demo.genericMethod;

import org.apache.logging.log4j.util.Strings;

public class GenericMethodTest {

	public static <E> void genric(E[] x) {

		for (E element : x) {
			System.out.printf("%E", element);
		}
		System.out.println();
	}

	public static void main(Strings args[]) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.2, 2.3, 4.4, 5.5, 8.9 };
		Character[] charArray = { 'a', 'd', 'f', 's', 'h' };

		System.out.println("print the integer array:");
		genric(intArray);

		System.out.println("print he double array");
		genric(doubleArray);

		System.out.println("print the char array");
		genric(charArray);
	}
}
