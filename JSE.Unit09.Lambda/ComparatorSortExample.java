/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 *
 * @author PA
 */
public class ComparatorSortExample {
    public static void main(String[] args) {
        Integer values[] = {12, 345, 34, 7, 9, 12, 9};
        
        Arrays.sort(values, /**new Comparator<Integer>(){
            @Override
            public int compare*/(Integer o1, Integer o2) -> {
                return o2 -o1;
//            }
        });
        
        Arrays.stream(values).forEach(e -> System.out.println(e + ","));
    }
}
