package lab9;

public class OuterClass {
	
	private String message = "hellow from outer class";
	
	class InnerClass {
		public void display() {
			System.out.println(message);
		}
		
	}
	
	class Main {
		public static void main(String arg[]) {
			
			OuterClass.InnerClass obj = new OuterClass().new InnerClass();
			obj.display();
		}
	}

}
