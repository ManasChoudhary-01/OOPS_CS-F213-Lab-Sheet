package lab8;
import java.util.*;
import java.util.function.*;

public class LambdaPractice {
    public static void main(String[] args) {
        // 1. A lambda that prints "Hello World"
        Runnable greet = () -> System.out.println("Hello World");
        greet.run();

        // 2. A lambda that adds two integers
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));

        // 3. A lambda that checks if a number is even
        Predicate<Integer> isEven = (a) -> a%2 == 0;
        System.out.println("Is 5 even? " + isEven.test(5));

        // 4. A lambda that returns the length of a string
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Lambda': " + stringLength.apply("Lambda"));

        // 5. A lambda with no parameters returning a string
        Supplier<String> getMessage = () -> "Returning a string";
        System.out.println(getMessage.get());

        // 6. Sorting a list using a lambda
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.sort((a,b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);
    }
}

