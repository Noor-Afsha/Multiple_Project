
public class DataHidingorEncapsulaion {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		DataHidingorEncapsulaion dbe=new DataHidingorEncapsulaion();
		
		dbe.setName("Noori");
		
		System.out.println(dbe.getName());
	}
}
