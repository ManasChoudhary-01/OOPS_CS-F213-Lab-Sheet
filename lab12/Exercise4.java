package lab12;

class BankAccount2 {
	private int balance;
	
	public BankAccount2(int initialBalance) {
		this.balance = initialBalance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void deposit(int amount) {
		balance += amount;
		try {
			Thread.sleep(200);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(Thread.currentThread().getName() + " deposited $" + amount + ", New Balance: $" + balance);
		notify();
	}
	
	public synchronized void withdraw(int amount) {
		while (balance < amount) {
            try {
                System.out.println("Waiting for deposit...");
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
		balance -= amount;
		System.out.println(Thread.currentThread().getName() + "Withdrew $" + amount + ", Balance: $" + balance);
	}
}

class ProducerOne extends Thread {
	private BankAccount2 account;
	
	public ProducerOne(BankAccount2 account) {
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
            account.deposit(40);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}

class ProducerTwo extends Thread {
	private BankAccount2 account;
	
	public ProducerTwo(BankAccount2 account) {
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
            account.deposit(30);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}

class ConsumerOne extends Thread {
	private BankAccount2 account;
	
	public ConsumerOne(BankAccount2 account) {
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
            account.withdraw(25);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}

class ConsumerTwo extends Thread {
	private BankAccount2 account;
	
	public ConsumerTwo(BankAccount2 account) {
		this.account = account;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
            account.withdraw(20);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}

public class Exercise4 {
	
	public static void main(String arg[]) throws InterruptedException {
		BankAccount2 bank = new BankAccount2(100);
		
		ProducerOne producer1 = new ProducerOne(bank);
		ProducerTwo producer2 = new ProducerTwo(bank);
		ConsumerOne consumer1 = new ConsumerOne(bank);
		ConsumerTwo consumer2 = new ConsumerTwo(bank);
		
		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
		
		producer1.join();
		producer2.join();
		consumer1.join();
		consumer2.join();
		
		System.out.println("Final balance is " + bank.getBalance());
	}
}
