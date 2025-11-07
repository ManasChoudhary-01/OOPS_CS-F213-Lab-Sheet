package lab8;

class Bo<T>{
	private T value;
	
	public void set(T value) {
		this.value= value;
	}
	
	public T get() {
		return value;
	}
}

public class GenericsDemo {
	
	public static void main(String arg[]) {
		Box<String> box1 = new Box<>();
		box1.set("Manas");
		System.out.println(box1.get());
		
		Box<Integer> box2 = new Box<>();
		box2.set(124);
		System.out.println(box2.get());
	}
}
