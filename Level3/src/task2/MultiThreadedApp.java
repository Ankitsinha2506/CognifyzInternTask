package task2;

public class MultiThreadedApp {
	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		// Create and start multiple worker threads
		Worker[] workers = new Worker[10];
		for(int i=0; i<workers.length; i++) {
			workers[i] = new Worker(counter);
			workers[i].start();
		}
		
		// Wait for all workers threads to finish.
		for(int i=0; i<workers.length; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Final Count : "+counter.getCount());
	}
}