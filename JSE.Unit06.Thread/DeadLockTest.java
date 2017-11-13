/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

/**
 *
 * @author PA
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        DeadLockDemo thread1 = new DeadLockDemo(obj1, obj2);
        DeadLockDemo thread2 = new DeadLockDemo(obj1, obj2);
        thread1.start();
        thread2.start();
    }
}
