package task2;


public class Worker extends Thread{
	private Counter counter;
	
	public Worker(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			counter.increment();
		}
	}
	
}
