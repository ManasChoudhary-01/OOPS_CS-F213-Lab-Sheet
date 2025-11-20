package lab12;

class SumThread implements Runnable{
	int[] array;
	
	public SumThread(int[] array){
		this.array = array; 
	}
	
	public void run() {
		int sum = 0;
		for(int i=0; i < array.length-1; i++) {
			sum += array[i];
			System.out.println("Sum so far is " + sum);
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ProductThread implements Runnable{
	int[] array;
	
	public ProductThread(int[] array){
		this.array = array; 
	}
	
	public void run() {
		int product = 1; 
		for(int value : array) {
			product *= value;
			System.out.println("Product so far is " + product);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Exercise2 {
	public static void main(String arg[]) throws InterruptedException {
		int[] array = {1,2,3,4,5,6};
		
		SumThread t1 = new SumThread(array);
		Thread ts1 = new Thread(t1);
		
		ProductThread t2 = new ProductThread(array);
		Thread tp1 = new Thread(t2);
		
		ts1.start();
		ts1.join();
		
		tp1.start();
	}
}
