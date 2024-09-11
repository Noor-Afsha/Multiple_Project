package Inheritance;

public class MultiLeveleInheritance {

	public static void main(String[] args) {

		Train train = new Train();
		train.displayAutomobile();
		train.displaySportCar();
		train.displayTruck();
		train.displayTrain();

	}
}

class Automobile {
	void displayAutomobile() {
		System.out.println("automobile");
	}
}

class SportCar extends Automobile {
	void displaySportCar() {
		System.out.println("SportCar");
	}

}

class Truck extends SportCar {
	void displayTruck() {
		System.out.println("Truck");
	}
}

class Train extends Truck {
	void displayTrain() {
		System.out.println("train");
	}

}
