
package techmatter.java6;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;
import java.util.concurrent.Executors;

public class ThreadPoolTest{
	public static void main(String...args){
		PrintNumber number = new PrintNumber();
		ExecutorService executor = Executors.newFixedThreadPool(3);// tao ra 3 thread
		IntStream.range(0, 6).forEach(i -> executor.submit(number));// range ?
	}
}