package lab10;
import java.util.logging.Logger;

public class BankAccount {
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logger.info("Deposited " + amount + ". New balance: " + balance);
        } else {
            logger.warning("Invalid deposit amount: " + amount);
        }
    }

    public double getBalance() {
        return balance; // Method to retrieve the current balance
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Test 1: Valid deposit
        System.out.println("Performing a valid deposit of 100.0...");
        account.deposit(100.0);
        System.out.println("Current balance: " + account.getBalance());

        // Test 2: Invalid deposit (negative amount)
        System.out.println("Attempting an invalid deposit of -50.0...");
        account.deposit(-50.0);
        System.out.println("Current balance: " + account.getBalance());

        // Test 3: Another valid deposit
        System.out.println("Performing another valid deposit of 200.0...");
        account.deposit(200.0);
        System.out.println("Current balance: " + account.getBalance());
    }
}

