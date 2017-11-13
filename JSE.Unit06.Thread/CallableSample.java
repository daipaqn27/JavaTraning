/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *
 * @author PA
 */
public class CallableSample implements Callable<Integer>{

    private ReentrantLock lock = new ReentrantLock();
    
    @Override
    public Integer call() throws Exception {     
        //lock.lock();
        AtomicInteger total = new AtomicInteger(0);
        IntStream.range(0, 10).forEach(number -> {
            System.out.println(Thread.currentThread().getName()
                    + " - object "+ this
                    + " running " + total.addAndGet(number));
            
            Random random = new Random();
            LongStream longStream = random.longs(100, 1000);
            try {
                Thread.sleep(longStream.findFirst().getAsLong());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        //lock.unlock();
        return total.get();
    }
}
