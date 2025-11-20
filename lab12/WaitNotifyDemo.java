package lab12;

class BankAccount1 {
    private double balance;

    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        synchronized (this) { // Locking the current object
            balance += amount;
            System.out.println("Deposited $" + amount + ", Balance: $" + balance);
            notify();
        }
    }

    public void withdraw(double amount) {
        synchronized (this) { // Locking the current object
            while (balance < amount) { // Wait for sufficient funds
                try {
                    System.out.println("Waiting for deposit...");
                    wait();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            balance -= amount;
            System.out.println("Withdrew $" + amount + ", Balance: $" + balance);
        }
    }
}

class Producer1 extends Thread {
    private BankAccount1 account;

    public Producer1(BankAccount1 account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(10);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer1 extends Thread {
    private BankAccount1 account;

    public Consumer1(BankAccount1 account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount1 account = new BankAccount1(0);
        Producer1 producer = new Producer1(account);
        Consumer1 consumer = new Consumer1(account);

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("Final Balance: $" + account.getBalance());
    }
}

