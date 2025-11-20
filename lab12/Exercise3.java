package lab12;
import java.util.*;

class SharedQueue {
	private final Queue<Integer> queue = new LinkedList<>();
	private  int size = 5;
	
	public synchronized void produce(int value) throws InterruptedException{
		while(queue.size() == size) {
			wait();
		}
		queue.add(value);
		System.out.println(value + " added to the list");
		notify();
	}
	
	public synchronized void consume() throws InterruptedException{
		while(queue.isEmpty()) {
			wait();
		}
		int val = queue.remove();
		System.out.println(val + "removed from the list");
		notify();
	}
	
}

public class Exercise3 {
	
	public static void main(String arg[]) throws InterruptedException {
		
		SharedQueue queue = new SharedQueue();
		
		Thread producer = new Thread(() -> {
				try {
					for(int i=0; i<20; i++) {
						int no = (int)(Math.random() * 100);
						queue.produce(no);
						Thread.sleep(200);
					}
				} catch(InterruptedException e) {
					 e.printStackTrace();
				}
		});

		
		Thread consumer = new Thread(() -> {
				try {
					for(int i=0; i<20; i++) {
						queue.consume();
						Thread.sleep(300);
					}
				} catch(InterruptedException e) {
					 e.printStackTrace();
				}
		});
		
		producer.start();
		consumer.start();
	}

}
