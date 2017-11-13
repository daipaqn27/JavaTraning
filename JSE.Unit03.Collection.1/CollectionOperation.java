package unit03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>(Arrays.asList(4, 5, 7, 9, 2, 8));
		Comparator<Integer> comparator = Integer::compare;
		Collections.sort(integers,comparator);
		
//		for (Integer integer : integers) {
//			System.out.println(integer);
//		}
		
//		integers.stream().filter(v -> v>5).forEach(v -> {
//			System.out.println(v);
//		});
		
		Integer[] values = 
				integers.stream().filter(v -> v>5).toArray(size -> new Integer[size]);
		Arrays.stream(values).forEach(v->{
			System.out.println(v);
		});
		
		Collector<Integer, ?, IntSummaryStatistics> collector =
				Collectors.summarizingInt(Integer::intValue);
		IntSummaryStatistics summaryStatistics = integers.stream().collect(collector);
		
		System.out.println(summaryStatistics.getSum());
		System.out.println(summaryStatistics.getAverage());
		
		System.out.println(integers.stream().reduce(Integer::sum).get());
		System.out.println(integers.stream().reduce(0,Integer::sum));
		System.out.println(integers.stream().reduce(0,(x,y)->x+y));
		
		Consumer<Integer> myConsumer = n->{
			System.out.println("user input value: " + n);
			if(n<5){
				System.out.println("Invalid value");
				return;
			}
			integers.add(n);
			integers.forEach(x->System.out.print(x + "-"));
		};
		myConsumer.accept(12);
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println();
			System.out.print("Please input a number: ");
			int value = scanner.nextInt();
			if(value == 0){
				break;
			}
			myConsumer.accept(value);
		}
	}
}
