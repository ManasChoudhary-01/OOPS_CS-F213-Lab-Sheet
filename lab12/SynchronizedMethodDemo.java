package lab12;

//package TaskRunnable;

class BankAccountSynchronizedMethods {
    private double balance;

    public BankAccountSynchronizedMethods(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized double getBalance() { // Synchronized method
        return balance;
    }

    public synchronized void deposit(double amount) { // Synchronized method
        double temp = balance;
        temp += amount;

        try {
            Thread.sleep(300); // Simulating delay
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        balance = temp;
        System.out.println("After deposit, balance = $" + balance);

        notify(); // Notify waiting threads
    }

    public synchronized void withdraw(double amount) { // Synchronized method
        while (balance < amount) { // Wait for sufficient funds
            try {
                wait(); // Release lock and enter waiting state
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        double temp = balance;
        temp -= amount;

        try {
            Thread.sleep(200); // Simulating delay
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        balance = temp;
        System.out.println("After withdrawal, balance = $" + balance);
    }
}

class ProducerSynchronized extends Thread {
    private BankAccountSynchronizedMethods account;

    public ProducerSynchronized(BankAccountSynchronizedMethods account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(10);
        }
    }
}

class ConsumerSynchronized extends Thread {
    private BankAccountSynchronizedMethods account;

    public ConsumerSynchronized(BankAccountSynchronizedMethods account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(10);
        }
    }
}

public class SynchronizedMethodDemo {
    public static void main(String[] args) {
    	
        BankAccountSynchronizedMethods account = new BankAccountSynchronizedMethods(50);
        ProducerSynchronized producer = new ProducerSynchronized(account);
        ConsumerSynchronized consumer = new ConsumerSynchronized(account);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Final balance: $" + account.getBalance());
    }
}

