package Inheritance;

public class AvoidingInehritance {

	public static void main(String[] args) {

		Son s = new Son();
		System.out.println(s.money);
		s.PracticeYoga();
		System.out.println();
	}

	long money = 999L;
	private String name = "Noor";

	void PracticeYoga() {
		System.out.println("yoga");
		System.out.println("private varialbe " + name);
		Smoke();
	}

	private void Smoke() {
		System.out.println("somke");
	}
}

class Son extends AvoidingInehritance {

}
