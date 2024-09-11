

	interface Sayable{
		
		default void say() {//default method
			System.out.println("hello");
		}
		void sayMore(String args[]);//abstract method
	}
	
	public class DefaultMethods implements Sayable{

		public void sayMore(String msg) {//implementing abstarct method

			System.out.println("bye");
		}
		
		static void moon(String string) {
			System.out.println("lets works");
		}
		
		public static void main(String[] args) {
			
			DefaultMethods dm=new DefaultMethods();
			
			dm.say();
			dm.sayMore("");
			dm.moon("moon is shing");
		
			
		}

		@Override
		public void sayMore(String[] args) {
			// TODO Auto-generated method stub
			
		}

		
	}

