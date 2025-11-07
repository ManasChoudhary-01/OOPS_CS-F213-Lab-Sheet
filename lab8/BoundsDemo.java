package lab8;
import java.util.*;

public class BoundsDemo {
	
	public static void printList(List<? extends Number> list) {
		for(Number num : list) {
			System.out.println(num.doubleValue());
		}
	}
	
	public static void addIntegers(List<? super Integer> list) {
		list.add(10);
		list.add(20);
	}
	
	public static void main(String arg[]) {
		List<Double> doubleList = Arrays.asList(1.1,1.3,1.4);
		printList(doubleList);
		
		List<Number> numberList = new ArrayList<>();
		addIntegers(numberList);
		printList(numberList);
	}

}
