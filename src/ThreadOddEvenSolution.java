
public class ThreadOddEvenSolution {

	public static void main(String[] args) {

		OddEvenProcessor oddEvenProcessor = new OddEvenProcessor();
		int max = 10;
		Thread t1 = new Thread(new ThreadSheduler(oddEvenProcessor, false, max));
		Thread t2 = new Thread(new ThreadSheduler(oddEvenProcessor, true, max));

		t1.start();
		t2.start();
	}

}

class ThreadSheduler implements Runnable {

	private boolean isEven;

	private OddEvenProcessor processor;

	int max;

	ThreadSheduler(OddEvenProcessor processor, boolean isEven, int max) {
		this.processor = processor;
		this.isEven = isEven;
		this.max = max;
	}

	@Override
	public void run() {
		int cnt = isEven ? 2 : 1;
		while (cnt < max) {
			if (isEven) {
				processor.printEven(cnt);
			} else {
				processor.printOdd(cnt);
			}
			cnt += 2;
		}

	}

}

class OddEvenProcessor {
	private volatile boolean isOdd;

	public synchronized void printEven(int number) {
		while (!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "   " + number);
		isOdd = false;
		notifyAll();
	}

	public synchronized void printOdd(int number) {
		while (isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "   " + number);
		isOdd = true;
		notifyAll();
	}
}