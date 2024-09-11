package Inheritance;

public class Vehicale {

	public static void main(String[] args) {
		
		Bus b=new Bus();
		b.display();
		b.displayBus();
	}

}
class Car{
		void display() {
			System.out.println("New car collection");
		}
	}
	class Bus extends Car{
		void displayBus() {
			System.out.println("display bus");
		}
	}
	

