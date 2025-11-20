package lab12;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        synchronized (this) { // Locking the current object
//            double temp = balance;
//            temp += amount;
//            try {
//                Thread.sleep(300); // Simulating delay
//            } catch (InterruptedException e) {
//                System.err.println(e.getMessage());
//            }
//            System.out.println("After deposit, balance = $" + temp);
//            balance = temp;
        	balance += amount;
        	try {
        		Thread.sleep(300);
        	} catch (InterruptedException e) {
        		System.out.println(e.getMessage());
        	}
        	System.out.println("After deposit, balance = $" + balance);
        }
    }

    public void withdraw(double amount) {
        synchronized (this) { // Locking the current object
            if (balance < amount) {
                System.out.println("Insufficient funds!");
                return;
            }
            double temp = balance;
            temp -= amount;
            try {
                Thread.sleep(200); // Simulating delay
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("After withdrawal, balance = $" + temp);
            balance = temp;
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Producer extends Thread {
    private BankAccount account;

    public Producer(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(10);
        }
    }
}

class Consumer extends Thread {
    private BankAccount account;

    public Consumer(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(10);
        }
    }
}

public class ManualSynchronisationDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(100);
        Producer producer = new Producer(account);
        Consumer consumer = new Consumer(account);

        producer.start();
        producer.join();
        
        consumer.start();
        consumer.join();

        System.out.println("Final Balance: $" + account.getBalance());
    }
}

