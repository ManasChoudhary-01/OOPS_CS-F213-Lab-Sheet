package lab12;

class MyThread2 extends Thread {
    public void start() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}

public class StartOverrideDemo {
    public static void main(String[] args) {
        MyThread2 t = new MyThread2();
        t.start(); // Starts a new thread (or so we expect)
    }
}

