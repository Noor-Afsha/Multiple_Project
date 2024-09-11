package Inheritance;

public class HieraricalInheritance {

	public static void main(String[] args) {

		SoftwareEngineer se = new SoftwareEngineer();
		se.displayEngineer();
		se.softwareEngineer();

		CivilENgineer sc = new CivilENgineer();
		sc.displayEngineer();
		sc.civilEnginee();

		MechanicalEngineer me = new MechanicalEngineer();
		me.displayEngineer();
		me.mechanicalEngineer();

		Tester t = new Tester();
		t.tester();
		t.displayEngineer();
		t.softwareEngineer();

		Developer d = new Developer();
		d.developer();
		d.displayEngineer();
		d.softwareEngineer();

	}
}

class Engineer {
	void displayEngineer() {
		System.out.println("Engineer");
	}
}

class SoftwareEngineer extends Engineer {
	void softwareEngineer() {
		System.out.println("SoftwareEngineer");
	}
	
	
}

class CivilENgineer extends Engineer {
	void civilEnginee() {
		System.out.println("civilENgineer");
	}
}

class MechanicalEngineer extends Engineer {
	void mechanicalEngineer() {
		System.out.println("mechanicale engineer");
	}
}

class Developer extends SoftwareEngineer {
	void developer() {
		System.out.println("developer");
	}
}

class Tester extends SoftwareEngineer {
	void tester() {
		System.out.println("tester");
	}
}