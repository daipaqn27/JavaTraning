package unit02;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		String[] values = {"d","a","b","e","f","c"};
		Arrays.sort(values);
		for(int i = 0; i < values.length; i++){
			System.out.println(values[i]);
		}
		
		System.out.println("==============");
		
		Arrays.sort(values, (o1, o2) -> {
			return o2.compareTo(o1);
		});
		
		for(int i = 0; i < values.length; i++){
			System.out.println(values[i]);
		}
	}
}
