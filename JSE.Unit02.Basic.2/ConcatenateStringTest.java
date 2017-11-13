package unit02;

public class ConcatenateStringTest {
	public static void main(String[] args) {
		int max = 1000000;
		String text = "";
		Long start = System.currentTimeMillis();
		for(int i = 0; i < max; i++){
			text += String.valueOf(i);
		}
		System.out.println("Time 1: " + (System.currentTimeMillis() - start));
		
		StringBuilder builder = new StringBuilder();
		start = System.currentTimeMillis();
		for(int i = 0; i < max; i++){
			builder.append(String.valueOf(i));
		}
		System.out.println("Time 2: " + (System.currentTimeMillis() - start));
		
		StringBuffer buffer = new StringBuffer();
		start = System.currentTimeMillis();
		for(int i = 0; i < max; i++){
			buffer.append(String.valueOf(i));
		}
		System.out.println("Time 3: " + (System.currentTimeMillis() - start));
	}
}
