package lab12;

class Thread1 extends Thread {
	String name;
	
	public Thread1(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0; i<=10; i++) {
			Thread.currentThread().setName(name);
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(150);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class Thread2 extends Thread {
	String name;
	
	public Thread2(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0; i<=10; i++) {
			Thread.currentThread().setName(name);
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(250);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class Thread3 extends Thread {
	String name;
	
	public Thread3(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0; i<=10; i++) {
			Thread.currentThread().setName(name);
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(350);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Exercise1 {
	public static void main(String arg[]) {
		Thread1 t1 = new Thread1("Counter-1");
		Thread2 t2 = new Thread2("Counter-2");
		Thread3 t3 = new Thread3("Counter-3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
