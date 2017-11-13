package unit02;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ArraySteamMax {
	public static void main(String[] args) {
		Integer[] values = {1, 9, 8, 4, 3, 2, 10, 11, 5, 7};
		Stream<Integer> stream =  Arrays.stream(values);
		Optional<Integer> max =  stream.max((o1, o2) -> {
			return o1 - o2;
		});
		System.out.println("Gia tri lon nhat: " + max.get());
		
		stream = Arrays.stream(values);
		Predicate<Integer> predicate = value -> {
			return value > 5;
		};
		System.out.print("Gia tri > 5 : ");
		stream.filter(predicate).forEach(value -> 
			System.out.print(value + " "));
	}
}
