import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCountWordFre {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		List<List<String>> sttr = Arrays.asList(Arrays.asList("bala","murali","bale"),Arrays.asList("nub","murali","bala"),
				Arrays.asList("bala","er","bale"),Arrays.asList("sd","murali","basla","bala"));
		
		Reader reader = new Reader();
		for(List<String> sd : sttr) {
			executorService.submit(new Processor(reader, "bala", sd));
		}
		
		executorService.shutdown();
		//executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
		
		System.out.println(reader.count.get());
		
	}

}

class Processor implements Runnable {

	Reader reader;
	List<String> str;
	String word;

	Processor(Reader reader, String word, List<String> str) {
		this.reader = reader;
		this.word = word;
		this.str = str;
	}

	@Override
	public void run() {
		reader.checkFrequency(str, word);
	}
}

class Reader {

	AtomicInteger count = new AtomicInteger(0);

	public void checkFrequency(List<String> str, String word) {
		for (String st : str) {
			if (st == word) {
				count.incrementAndGet();
			}
		}
	}

}