/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author PA
 */
//fail
public class InvokeAllExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();
        
        List<CallableSample> callables = Arrays.asList(
           new CallableSample(), new CallableSample(), new CallableSample()
        );
        
        try {
            Stream stream = executor.invokeAll(callables).stream();
            Stream resultStream = stream.map(future -> {
                return future.getClass();
            });
            
            Integer results[] = (Integer[]) resultStream.toArray(Integer[]::new);
            Arrays.stream(results).forEach(System.out::println);
            System.out.println("---------->" + executor.invokeAny(callables));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
