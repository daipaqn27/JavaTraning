/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
public class DeadLockDemo extends Thread{
    private Object lock1;
    private Object lock2;
    
    public DeadLockDemo(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    
    public void run(){
        synchronized(lock1){
            System.out.println(Thread.currentThread().getName() + ": Holding"+ lock1 + "...");
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + ":Waiting for" + lock2 + "...");
            } catch (InterruptedException ex) {
                Logger.getLogger(DeadLockDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
            synchronized(lock2){
                System.out.println(Thread.currentThread().getName() + "-------->" + lock1 + ":" + lock2 + "...");
            }            
        }
    }
}