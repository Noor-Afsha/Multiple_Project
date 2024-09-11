
public class ConstructorChaining {

	private String name;
	private int age;

	public ConstructorChaining() {

	}

	public ConstructorChaining(String name) {
		this.name = name;

	}

	public ConstructorChaining(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		ConstructorChaining c = new ConstructorChaining();
		ConstructorChaining c1 = new ConstructorChaining("john");
		ConstructorChaining c2 = new ConstructorChaining("noor", 23);

		System.out.println();
		System.out.println(c1.getName() );
		System.out.println(c2.getName() + c2.getAge());
	}

}
