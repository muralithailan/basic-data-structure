
public class ThreadOddEven {

	public static void main(String[] args) {
		Printer printer = new Printer();

		Thread t1 = new Thread(new TaskOddEven(10, false, printer));
		Thread t2 = new Thread(new TaskOddEven(10, true, printer));

		t1.start();
		t2.start();
	}

}

class TaskOddEven implements Runnable {
	int max;
	boolean isEven;
	Printer printer;

	TaskOddEven(int max, boolean isEven, Printer printer) {
		this.max = max;
		this.isEven = isEven;
		this.printer = printer;
	}

	@Override
	public void run() {

		int cnt = isEven ? 2 : 1;
		while (max >= cnt) {
			if (isEven) {
				printer.printEven(cnt);
			} else {
				printer.printodd(cnt);
			}
			cnt = cnt + 2;
		}

	}

}

class Printer {
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

		System.out.println(Thread.currentThread().getName() + "    " + number);

		isOdd = false;

		notifyAll();

	}

	public synchronized void printodd(int number) {
		while (isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + "    " + number);

		isOdd = true;
		notifyAll();
	}

}