/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
public class ThreadNumberTest {
    public static  void main(String...args) throws InterruptedException{
        PrintNumber number = new PrintNumber();
        
        Thread thread = new Thread(number);
        thread.setName("Hanoi_Thread");
        thread.setDaemon(true);
        thread.start();
        
//        while(thread.isAlive()){
//            if(number.getNumber() % 10 == 0){
//                number.setAlive(false);
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }
//        Thread.currentThread().join();
        System.out.println("Main Thread say hello");
        System.out.println("Main Thread say googlebye");
    }
}
