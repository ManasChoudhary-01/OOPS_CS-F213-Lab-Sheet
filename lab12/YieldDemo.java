package lab12;

class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread");
            Thread.yield();
        }
    }
}

public class YieldDemo {
    public static void main(String args[]) {
        MyThread1 t = new MyThread1();
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        }
     
    }
}
