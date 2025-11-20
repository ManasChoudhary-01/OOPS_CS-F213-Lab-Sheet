package lab12;

class Worker extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Worker running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Exception ignored
            }
        }
    }
}

public class JoinDemo {
    public static void main(String args[]) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        worker.join(); // Main waits until worker finishes
        System.out.println("Worker completed, main continues.");
    }
}
