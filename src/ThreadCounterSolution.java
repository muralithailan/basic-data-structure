import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounterSolution {

	public static void main(String[] args) {

		Counter cnt = new Counter(100);
		Thread t1 = new Thread(cnt);
		Thread t2 = new Thread(cnt);
		Thread t3 = new Thread(cnt);

		t1.start();
		t2.start();
		t3.start();
	}

	static class Counter implements Runnable {

		AtomicInteger cnt = new AtomicInteger(0);
		int threshold;

		Counter(int thres) {
			this.threshold = thres;
		}

		@Override
		public void run() {

			System.out.println(Thread.currentThread() + "        " + cnt.incrementAndGet());

		}

	}
}
