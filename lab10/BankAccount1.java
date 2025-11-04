package lab10;
import java.util.logging.Logger;

public class BankAccount1 {
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());
    private double balance;

    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
        logger.info("Bank account created with initial balance: " + initialBalance);
    }

    public void deposit(double amount) {
        assert amount > 0 : "Deposit amount must be positive";
        if (amount > 0) {
            balance += amount;
            logger.info("Deposited " + amount + ". Current balance: " + balance);
        } else {
            logger.warning("Invalid deposit amount: " + amount);
        }
    }

    // Withdraw method with assertions and logging
    public void withdraw(double amount) {
        assert amount <= balance : "Insufficient balance!";
        try {
            if (amount <= balance) {
                balance -= amount;
                logger.info("Withdrew " + amount + ". Current balance: " + balance);
            } else {
                throw new Exception("Insufficient funds");
            }
        } catch (Exception e) {
            logger.severe("Failed to withdraw: " + e.getMessage());
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Create a BankAccount object with an initial balance of 500
        BankAccount1 account = new BankAccount1(500);

        // Test Case 1: Valid deposit
        System.out.println("Performing valid deposit of 200:");
        account.deposit(200);
        // Should log the deposit and update the balance
        System.out.println("Current balance: " + account.getBalance());

        // Test Case 2: Invalid deposit (negative amount)
        System.out.println("\nPerforming invalid deposit of -50:");
        account.deposit(-50);
        // Should log a warning and do nothing

        // Test Case 3: Valid withdrawal
        System.out.println("\nPerforming valid withdrawal of 100:");
        account.withdraw(100);
        // Should log the withdrawal and update the balance
        System.out.println("Current balance: " + account.getBalance());

        // Test Case 4: Invalid withdrawal (exceeds balance)
        System.out.println("\nPerforming invalid withdrawal of 700:");
        account.withdraw(700);
        // Should log a severe error for insufficient funds

        // Test Case 5: Another valid deposit and withdrawal
        System.out.println("\nPerforming valid deposit of 300:");
        account.deposit(300);
        // Deposit should be successful

        System.out.println("Performing valid withdrawal of 200:");
        account.withdraw(200);
        // Withdrawal should be successful

        System.out.println("Current balance: " + account.getBalance());
    }
}

