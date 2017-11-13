/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab10;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PA
 */
public class ConcurrencyExample {
    public static  void addData(List<Integer> list) throws InterruptedException{
        while(true){
            int random = (int) (Math.random()*100);
            list.add(random);
            System.out.println("add new data " + random);
            Thread.sleep(100l);
        }
    }
    
    public static void printData(List<Integer> list){
        while(true){
            try{
                System.out.println("================================");
                list.forEach(value -> System.out.println("value= " + value));
                Thread.sleep(80l);
            }catch(Exception e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            try {
                addData(list);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        new Thread(() -> printData(list)).start();
    }
}
