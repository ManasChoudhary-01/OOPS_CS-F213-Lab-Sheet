package lab10;
import java.util.*;

public class Number implements Comparable<Number> {

	int v;

	public Number(int v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return String.valueOf(v);
	}
	
	@Override
	public int compareTo(Number o) {
		return this.v - o.v;
	}
	
	public static void main(String[] args) {
		
	Number[] n = { new Number(4), new Number(1), new Number(7), new Number(2) };
	System.out.println("Before Sorting: "+ Arrays.toString(n));
	
	Arrays.sort(n);
	System.out.println("After Sorting: " + Arrays.toString(n));
	}
}