/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
public class FileOutputExample {

    public static void main(String[] args) {
        File file = new File("C:" + File.separator + "Temp"
                + File.separator + "hanoijava.txt");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = "Hello Ha Noi Java Class".getBytes();
            outputStream.write(bytes);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
        }
        
        try{
            FileInputStream inputStream = new FileInputStream(file);
            byte bytes[] = new byte[4*1024];
            int read = -1;
            StringBuilder builder = null;
            while((read = inputStream.read(bytes)) !=-1){
                builder.append(new String(bytes, 0, read));
            }
            inputStream.read(bytes);
            System.out.println("[" + new String(bytes) + "]");
            System.out.println("[" + builder + "]");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
