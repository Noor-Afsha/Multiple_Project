
public class ConstructorUsingThisKeyword {
public static void main(String[] args) {
		
		Cran c = new Cran("noor", "blue");
		
		System.out.println(c.getName());
		System.out.println(c.getColor());

	}

	private String name;

	public ConstructorUsingThisKeyword(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Cran extends ConstructorUsingThisKeyword {
	private String color;

	public Cran(String name, String color) {
		super(name);
		this.color = color;

	}

	public String getColor() {
		return color;
	}	public class Test{
	}
}
	