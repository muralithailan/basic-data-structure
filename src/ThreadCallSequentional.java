import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCallSequentional {

	public static void main(String[] args) {

		Lock lock = new ReentrantLock();

		Condition c1 = lock.newCondition();

		ThreadId threadId = new ThreadId();
		threadId.id = 1;
		int max = 2;
		Thread t1 = new Thread(new Sheduler(1, max, lock, c1, 1, 2, threadId));
		Thread t2 = new Thread(new Sheduler(2, max, lock, c1, 2, 3, threadId));
		Thread t3 = new Thread(new Sheduler(3, max, lock, c1, 3, 1, threadId));

		t1.start();
		t2.start();
		t3.start();
	}

}

class ThreadId {
	int id;
}

class Sheduler implements Runnable {

	int num;
	Lock lock;
	Condition c1;
	int current;
	int next;
	ThreadId threadid;
	static AtomicInteger count =new  AtomicInteger(0);
	int max;

	Sheduler(int num, int max, Lock lock, Condition c1, int current, int next, ThreadId threadid) {
		this.num = num;
		this.max = max;
		this.lock = lock;
		this.c1 = c1;
		this.current = current;
		this.next = next;
		this.threadid = threadid;
	}

	@Override
	public void run() {
		while (count.get() < max) {
			lock.lock();
			try {

				while (current != threadid.id) {
					try {
						c1.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(count.get() > max) {
					break;
				}
				System.out.println(Thread.currentThread().getName() + "   " + num +" Count :"+count.incrementAndGet());
				
				threadid.id = next;
				c1.signal();
				
			} finally {
				lock.unlock();
			}
		}

	}

}