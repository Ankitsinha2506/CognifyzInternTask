package task2;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		BankAccount account = new BankAccount(10000);
		
		// Create teller threads.
		Thread teller1 = new Thread(new Teller(account, true, 200), "Teller1");
		Thread teller2 = new Thread(new Teller(account, true, 200), "Teller2");
//		Thread teller3 = new Thread(new Teller(account, true, 200), "Teller3");
//		Thread teller4 = new Thread(new Teller(account, true, 200), "Teller4");
//		Thread teller5 = new Thread(new Teller(account, true, 200), "Teller5");
//		Thread teller6 = new Thread(new Teller(account, true, 200), "Teller6");
//		
		
		teller1.start();
		teller2.start();
//		teller3.start();
//		teller4.start();
//		teller5.start();
//		teller6.start();
		
		teller1.join();
		teller2.join();
//		teller3.join();
//		teller4.join();
//		teller5.join();
//		teller6.join();
		
		System.out.println("Final Balance : "+ account.getBalance());	
	}

}
