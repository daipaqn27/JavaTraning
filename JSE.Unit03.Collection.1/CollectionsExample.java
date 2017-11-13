package unit03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {
	public static void main(String[] args) {
		Short[] shorts = {1, 3, 5, 7, 8, 9};
		
		List<Short> lists = new ArrayList<>();
		Collections.addAll(lists, shorts);
		
		Collections.reverse(lists);
		
		lists.toArray(shorts);
		for(int i = 0; i < shorts.length; i++){
			System.out.println(shorts[i]);
		}
	}
}
