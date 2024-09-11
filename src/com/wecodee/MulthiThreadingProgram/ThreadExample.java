package com.wecodee.MulthiThreadingProgram;

class MyThread extends Thread {

	@Override
	public void run() {

		int i = 0;

		while (i < 1) {

			System.out.println("Thread can be created by two ways");

			System.out.println("byExtending the class object and by implementing the runnable interface");

			i++;
		}
	}
}

class MyThread2 extends Thread {

	@Override
	public void run() {

		int i = 0;

		while (i < 3) {

			System.out.println("I am happy");

			System.out.println("I am sad");
			i++;
		}
	}
}

class MyThread3 extends Thread {

	@Override
	public void run() {

		int i = 0;

		while (i <= 10) {

			System.out.println("in thread method 3 is also extends");

			System.out.println("i am very happy after getting the result of my practice");

			i++;

		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();

		t1.start();
		t2.start();
		t3.start();
	}
}
