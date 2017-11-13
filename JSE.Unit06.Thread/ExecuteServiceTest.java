package techmatter.java6;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

class ExecuteServiceTest{
	public static void main(String...args){
		PrintNumber number = new PrintNumber();
		Callable<Object> value = Executors.callable(number);
		System.out.println(" main say hello");

		try{
			value.call();
		}catch(Exception e){ e.printStackTrace(); }

		System.out.println(" main say goodbye");
	}
}
// goi wa callable se khac gi goi start thong thuong nhi