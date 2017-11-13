/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author PA
 */
public class SynchronizedExample {
    public static void addData(List<Integer> list){
        IntStream.range(0, 1000).forEach(index ->{
            try {
                list.add(index);
            } catch (Exception e) {
            }
        });
    }
    
    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> values = new ArrayList<List<Integer>>();
        for(int i = 0; i < 10; i++){
            List<Integer> list = new ArrayList<>();
            new Thread(()-> addData(list));
            new Thread(()-> addData(list));
            values.add(list);
        }
        
        Thread.sleep(5*1000);
        values.forEach(list -> System.out.println("number items of list---->" + list.size()));
    }
}
