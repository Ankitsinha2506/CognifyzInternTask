package task2;

public class BankAccount {
	
	private double balance;
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	public synchronized void deposit(double amount) {
		balance += amount;
		System.out.println(Thread.currentThread().getName() + " Deposited" + amount + " . New Balance: " + balance);
	}
	
	public synchronized void withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.println(Thread.currentThread().getName() + " withdrew " + amount + " . new Balance " + balance);
		}
		else {
			System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + ". Insufficient Funds, Balance: "+ balance);
		}
	}
	
	public double getBalance() {
		return balance;
	}
}
