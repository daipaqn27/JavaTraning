/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 *///fail
public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Map<String, String> map = new HashMap<String, String>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        
        executorService.submit(() -> {
            System.out.println("Start writing");
            lock.writeLock().lock();
            try{
                TimeUnit.SECONDS.sleep(10);
                map.put("foo", "bar");
            } catch (InterruptedException ex) {
                Logger.getLogger(ReadWriteLockExample.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                lock.writeLock().unlock();
                System.out.println("end writing");
            }
        });
        
        Runnable readTask = () -> {
                System.out.println("start reading");
                lock.readLock().lock();
                try{
                    System.out.println(map.get("foo"));
                }finally{
                    lock.readLock().unlock();
                    System.out.println("end reading");
                }
        };
        
        executorService.submit(readTask);
        executorService.submit(readTask);
    }
}
