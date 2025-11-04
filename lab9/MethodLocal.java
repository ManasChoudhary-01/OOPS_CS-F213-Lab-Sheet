package lab9;

public class MethodLocal {
	
	public void displayMessage() {
		
		class Inner {
			public void show() {
				System.out.println("Hello from Method-Local Inner Class!");
			}
		}
		
		Inner innerObj = new Inner();
		innerObj.show();
	}
	
	public static void main(String arg[]) {
//		MethodLocal outerObj = new MethodLocal();
		new MethodLocal().displayMessage();
	}

}
