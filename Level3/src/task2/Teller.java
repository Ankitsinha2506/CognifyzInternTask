package task2;


public class Teller implements Runnable{
	private BankAccount account;
	private boolean deposit;
	private double amount;
	
	public Teller(BankAccount account, boolean deposit, double amount) {
		this.account = account;
		this.deposit = deposit;
		this.amount = amount;
	}

	@Override
	public void run() {
		try
		// (Scanner sc = new Scanner(System.in);)
		{
			// System.out.println("Enter Your Transaction : ");
			// int trans = sc.nextInt();
			for(int i=0; i<5; i++) {
				if(deposit) {
					account.deposit(amount);
				}
				else {
					account.withdraw(amount);
				}
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
