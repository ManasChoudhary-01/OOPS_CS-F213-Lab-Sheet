package lab12;

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
            try {
                Thread.sleep(500); // pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception caught");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // starts a new thread
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

