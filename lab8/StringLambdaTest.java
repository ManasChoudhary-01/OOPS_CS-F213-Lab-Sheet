package lab8;

interface StringOperation {
    String operate(String input);
}

public class StringLambdaTest {
    public static void main(String[] args) {
        // 1. Convert a string to uppercase
        StringOperation toUpperCase = s -> s.toUpperCase();
        System.out.println("Uppercase: " + toUpperCase.operate("hello"));

        // 2. Reverse a string
        StringOperation reverse = str -> new StringBuilder(str).reverse().toString();
        System.out.println("Reversed: " + reverse.operate("lambda"));

        // 3. Check if a string is a palindrome (return "Yes" or "No")
        StringOperation isPalindrome = str -> {
        	// str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()) ? "Yes"  : "NO";
        	if(str.equals(new StringBuilder(str).reverse().toString())) {
        		return "Yes";
        	} else {
        		return "No";
        	}
        };	
        System.out.println("Is 'radar' a palindrome? " + isPalindrome.operate("radar"));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome.operate("hello"));
    }
}

