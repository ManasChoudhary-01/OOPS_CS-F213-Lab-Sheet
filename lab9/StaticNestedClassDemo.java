package lab9;

class Out {
	static int outerX = 10;
	int outerY = 30;
	private static int pvtOuterZ = 20;
	
	static class StaticNestedClass {
		
		void display() {
			System.out.println("Value of outer x is " + outerX);
			// System.out.println("Value of outer y is " + outerY);
			System.out.println("Value of outer z is " + pvtOuterZ);
			
			Out outerObj = new Out();
			System.out.println("Value of outer y is " + outerObj.outerY);
			
		}	
	}
}

public class StaticNestedClassDemo {
	
	public static void main(String arg[]) {
		Out.StaticNestedClass staticNestedObj = new Out.StaticNestedClass();
		staticNestedObj.display();
	}

}
