package unit02;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ArrayStream {
	public static void main(String[] args) {
		Integer[] values = {1, 9, 8, 4, 3, 2, 10, 11, 5, 7};
		Arrays.sort(values, (o1, o2) -> {
			return o2 - o1;
		});
		
		System.out.print("for index: ");
		for(int i = 0; i < values.length; i++){
			if(i <  values.length - 1){
				System.out.print(values[i] + ",");
			}else {
				System.out.print(values[i]);
			}
		}
		
		System.out.println();
		
		System.out.println("Use Stream foreach: ");
		Stream<Integer> stream =  Arrays.stream(values);
//		stream.forEach(value -> {
//			System.out.print(value + ",");
//		});
		
		System.out.print("Use consumer foreach: ");
		Consumer<Integer> c = value -> {
				System.out.print(value + ",");
			};
		stream.forEach(c);
	}
	
}
