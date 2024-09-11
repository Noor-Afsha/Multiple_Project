package Methods;
class Vehicale {

	void run() {

		System.out.println("bike is running");
	}
}

class Bike extends Vehicale {

	public static void main(String[] args) {

		Bike b = new Bike();

		b.run();

	}
}