public class Employee {
  private int id;
  private String name;
  private int age;
  private double salary;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

 public static void main(String[] args) {
	
	 Employee emp=new Employee();
	 emp.setSalary(1000.33);
	System.out.println("salry " +emp.getSalary());
}
}
