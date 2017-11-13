package techmatter.java6;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class SimpleThreadSample {

    public static void main(String args[]) {
        //args = new String[]{"1", "2", "3"};
        new Thread(() -> {
            Arrays.stream(args).forEach(ele -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimpleThreadSample.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(ele);
            });
        }).start();
    }
}