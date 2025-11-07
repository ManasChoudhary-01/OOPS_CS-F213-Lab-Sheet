package lab8;
import java.util.*;

//[1] Generic Class with Upper Bound
class Box<T> { 
    private T value; 

    public void set(T value) { 
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void printDouble() {
        System.out.println("Double value: " + ((Number) value).doubleValue());
    }
}

//[2] Generic Method
class Printer {
    public static <T> void printArray(T[] array) { 
        for (T item : array) { 
            System.out.println("Item: " + item);
        }
    }
}

public class Exercise1 {
	
    // [3] Upper Bound Wildcard – reading only
    public static void printNumbers(List<? extends Number> list) { 
        for (Number num : list) {
            System.out.println("Read: " + num.doubleValue());
        }
    }

    // [4] Lower Bound Wildcard – safe for writing integers
    public static void addIntegers(List<? super Integer> list) { 
        list.add(10);
        list.add(20);
        System.out.println("Added integers to list.");
    }

    public static void main(String[] args) {
        // Using Generic Class
        Box<Integer> intBox = new Box<>(); 
        intBox.set(42);
        System.out.println("Box contains: " + intBox.get());
        intBox.printDouble();

        Box<Double> doubleBox = new Box<>(); 
        doubleBox.set(3.14);
        doubleBox.printDouble();
    }
}
