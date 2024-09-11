package Inheritance;

class Food{
	void display() {
		System.out.println("food are very tasty");
	}
}

class Pizza extends Food{
	void pizaDisplay() {
		System.out.println("Pizza is extends by food");
	}
}
public class SingleLevel{
	
	public static void main(String[] args) {
		Pizza p=new Pizza();
		p.display();
		p.pizaDisplay();
		
		
	}
}
