package techmatter.java6;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintMessage implements Runnable, Serializable {

    private String message;
    //private boolean alive = true;

//	public int getNumber(){ return number; }
    public PrintMessage(String message) {
        this.message = message;
    }

//	public void setAlive(boolean alive){ this.alive = alive }
    public synchronized void run() {
        try {

            String elements[] = message.split(" ");
            Arrays.stream(elements).forEach(ele -> {
                System.out.println(Thread.currentThread().getName() + " print " + ele);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    //Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
        	Thread.sleep((int)(Math.random()*3)*1000);
        }catch(Exception e){
        	e.printStackTrace();
        }

//        Thread current = Thread.currentThread();
//        while (alive) {
//            number++;
//            System.out.println(current.getName() + "number is \"" + number + "\"");
//            Thread.sleep(800);
//        }
//        System.out.println(current.getName() + " is stoped!");
    }
}

class ThreadTest{
public static void main(String args[]){
	PrintMessage message = new PrintMessage("Say hello to every one");
	new Thread(message).start();
	new Thread(message).start();
}
}
