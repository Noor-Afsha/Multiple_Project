package Inheritance;

final  class Circle {

	private final double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getCircumtance() {
		return 2 * Math.PI * radius;
	}
}
public class FinalClass{
	
	public static void main(String[] args) {
		
		Circle circle=new Circle(5);
		
		System.out.println("Area  "+ circle.getArea());
		System.out.println("Circumtances  "+ circle.getCircumtance());
	}
}
