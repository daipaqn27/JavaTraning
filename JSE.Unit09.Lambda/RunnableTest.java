/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab9;

/**
 *
 * @author PA
 */
public class RunnableTest {

    public static void main(String[] args) {
//        Runnable runnable = () -> {
//                System.out.println(Thread.currentThread().getName()+" say hello Java class!");
//        };

        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " say hello Java class!");
                    System.out.println("1+1=" + (1 + 1));
                }
        ).start();
    }
}
