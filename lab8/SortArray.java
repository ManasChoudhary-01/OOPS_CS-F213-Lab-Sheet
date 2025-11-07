package lab8;

public class SortArray {
	public static void main(String arg[]) {
		
		int[] array = {10, 15, 2, 99, 67, 10};
		
		for(int i=0; i< array.length-1; i++) {
			for(int j=0; j< array.length-1; j++) {
				if(array[j] > array[j+1]) {
					int swap = array[j];
					array[j] = array[j+1];
					array[j+1] = swap;
				}
			}
		}
		
		for(int a : array) {
			System.out.print(a + " ");
		}
	}
}
