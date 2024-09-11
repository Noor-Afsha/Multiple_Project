package String;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

	private final int age;
	private final String name;
	private final List<String> hobbies;

	public ImmutableClass(int age, String name, List<String> hobbies) {
		super();
		this.age = age;
		this.name = name;
		this.hobbies = new ArrayList<>(hobbies);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getHobbies() {
		return new ArrayList<>(hobbies);
	}

}
