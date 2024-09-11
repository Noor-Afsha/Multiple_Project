package Exceptation;

public class FinallyBlock {
	
	public static void main(String[] args) {
		
		try {
			
			int i=0;
			int j=10;
			int y=j/i;
			System.out.println(1000);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println(5000);
		}
	}

}
