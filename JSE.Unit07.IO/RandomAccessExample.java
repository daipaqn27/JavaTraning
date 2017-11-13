/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author PA
 */
public class RandomAccessExample {
    static  File file = new File("C:\\Temp2\\test1\\io_sample.txt");
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try{
            RandomAccessFile randomAccess = new RandomAccessFile(file, "rw");
            randomAccess.seek(9);
            byte bytes[] = new byte[4*1024];
            int read = randomAccess.read(bytes);
            System.out.println(new String(bytes, 0, read, "utf8"));
            
            randomAccess.seek(file.length());
            randomAccess.write("\r\n".getBytes());
            randomAccess.writeChars("Hello co ban");
            
            Desktop.getDesktop().open(file);
        }finally{
            
        }
    }
}
