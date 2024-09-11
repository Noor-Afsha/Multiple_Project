package AbstractClass;

public class Main {

	public static void main(String[] args) {

		Display c = new Display(new Cat());
		System.out.println();

		Display r = new Display(new Rabbit());
		System.out.println();

		Display cow = new Display(new Cow());

//		
//		Display d=new Display();
//		d.test(new Cat());
//		d.test(new Rabbit());
//		d.test(new Cow());
//		

	}

}
