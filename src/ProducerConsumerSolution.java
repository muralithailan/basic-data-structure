import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerSolution {

	public static void main(String[] args) {

		int BOUND = 10;
		int N_PRODUCERS = 4;
		int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
		int poisonPill = Integer.MAX_VALUE;
		int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
		int mod = N_CONSUMERS % N_PRODUCERS;
		 
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
		 
		for (int i = 1; i < N_PRODUCERS; i++) {
		    new Thread(new Producer(queue, poisonPill, poisonPillPerProducer)).start();
		}
		 
		for (int j = 0; j < N_CONSUMERS; j++) {
		    new Thread(new Consumer(queue, poisonPill)).start();
		}
		 
		new Thread(new Producer(queue, poisonPill, poisonPillPerProducer + mod)).start();
	}

}

class Producer implements Runnable {

	private BlockingQueue<Integer> buffer;
	private int stopSignal;
	private int stopSignalCnt;

	Producer(BlockingQueue<Integer> buffer, int stopSignal, int stopSignalCnt) {
		this.buffer = buffer;
		this.stopSignal = stopSignal;
		this.stopSignalCnt = stopSignalCnt;
	}

	@Override
	public void run() {
		pushDataToQueue();

	}

	private void pushDataToQueue() {
		for (int i = 0; i < 100; i++) {
			try {
				buffer.put(ThreadLocalRandom.current().nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < stopSignalCnt; j++) {
			try {
				buffer.put(stopSignal);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Consumer implements Runnable {

	private BlockingQueue<Integer> buffer;
	private int stopSignal;

	Consumer(BlockingQueue<Integer> buffer, int stopSignal) {
		this.buffer = buffer;
		this.stopSignal = stopSignal;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Integer number = buffer.take();
				if (number.compareTo(stopSignal) == 0) {
					return;
				}
				System.out.println("The number is : " + number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
