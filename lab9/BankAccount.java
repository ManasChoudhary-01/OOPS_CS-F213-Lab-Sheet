package lab9;
import java.util.*;

public class BankAccount {
	
	private String holdersName;
	private double initialBalance;
	
	private List<Transaction> transaction = new ArrayList<>();
	
	public BankAccount(String holdersName, double initialBalance) {
		this.holdersName = holdersName;
		this.initialBalance = initialBalance;
	}
	
	public double deposit(double amount) {
		assert amount > 0 : "Amount must be positive";
		
		if(amount > 0) {
			transaction.add(new Transaction("Deposit", amount));
			return initialBalance += amount;
		} else {
			System.out.println("Amount must be positive");
			return initialBalance;
		}
		
	}
	
	public double withdraw(double amount) {
		assert amount > 0 : "Amount must be positive";
		
		if(amount > 0 && amount <= initialBalance) {
			transaction.add(new Transaction("Withdraw", amount));
			return initialBalance -= amount;
		} else {
			System.out.println("Amount must be positive");
			return initialBalance;
		}
		
	}
	
	public void print_transactions() {
		System.out.println("Account Holder " + holdersName);
		System.out.println("Initial Balance " + initialBalance);
		System.out.println(" ");
		
		for(Transaction t : transaction) {
			System.out.println(t.type + " : " + t.amount);
		}
	}
	
	class Transaction {
		
		String type;
		double amount;
		
		public Transaction(String type, double amount) {
			this.type = type;
			this.amount = amount;
		}
	}
	
	public static void main(String arg[]) {
		BankAccount person1 = new BankAccount("Manas", 500.0);
		person1.deposit(300);
		person1.withdraw(100);
		person1.deposit(200);
		person1.print_transactions();
	}

}
