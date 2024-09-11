package com.example.demo.genericMethod;

public class GenericClassTest<T1, T2> {

	public void display(T1 var1, T2 var2) {
		System.out.println("Name: "+var1  +"ID: "+ var2);
	}

	public static void main(String[] args) {
		GenericClassTest<String, Integer> obj1 = new GenericClassTest<String, Integer>();
		GenericClassTest<Integer, Integer> obj2 = new GenericClassTest<Integer, Integer>();

		obj1.display("noor", 1);
		obj2.display(10, 12);

	}
}
