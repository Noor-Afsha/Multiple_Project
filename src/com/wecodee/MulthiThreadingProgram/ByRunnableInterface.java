package com.wecodee.MulthiThreadingProgram;

class MyThreadRunnable implements Runnable {

	@Override
	public void run() {

		int i = 0;

		while (i <= 3) {

			System.out.println("this is runnable interface");

			System.out.println("this is runnable ");

			i++;
		}
	}
}

class MyThreadRunnable2 implements Runnable {

	@Override

	public void run() {

		int i = 0;

		while (i < 5) {

			System.out.println("this is implementaions of ................");
			i++;
		}
	}
}

public class ByRunnableInterface {

	public static void main(String[] args) {

		MyThreadRunnable thread = new MyThreadRunnable();

		Thread t1 = new Thread(thread);

		MyThreadRunnable2 threads = new MyThreadRunnable2();

		Thread t2 = new Thread(threads);

		t1.start();

		t2.start();
	}
}
