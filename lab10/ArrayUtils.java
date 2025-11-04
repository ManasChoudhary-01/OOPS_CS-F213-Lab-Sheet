package lab10;
import java.util.Arrays;

public class ArrayUtils {

    public static void sortArray(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assert array[i] <= array[i + 1] : "Array not sorted properly!";
        }
    }

    public static void main(String[] args) {
    	
        // Test case 1: Sorted array
        int[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("Testing with sorted array: ");
        System.out.println(Arrays.toString(sortedArray));
        ArrayUtils.sortArray(sortedArray);
        System.out.println("Test case 1 passed.");

        // Test case 2: Unsorted array
        int[] unsortedArray = {5, 2, 4, 1, 3};
        System.out.println("Testing with an unsorted array:");
        System.out.println(Arrays.toString(unsortedArray));
        ArrayUtils.sortArray(unsortedArray); // Sorting and checking assertions
        System.out.println("Test case 2 passed.");

        // Test case 3: Invalid array (for assertion failure demo)
        int[] invalidArray = {5, 3, 4, 2, 1};
        System.out.println("Testing with an invalid (unsorted) array:");
        System.out.println(Arrays.toString(invalidArray));
        try {
            ArrayUtils.sortArray(invalidArray);
            // This will trigger the assertion after sorting
        } catch (AssertionError e) {
            System.out.println("AssertionError caught: " + e.getMessage());
        }
    }
}

