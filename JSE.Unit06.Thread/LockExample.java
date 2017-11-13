/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
public class LockExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool(4);

        CallableSample sample = new CallableSample();
        List<CallableSample> callables = Arrays.asList(
                new CallableSample(), new CallableSample(),
                new CallableSample(), new CallableSample()
        );

        try {
            executor.invokeAll(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(LockExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
