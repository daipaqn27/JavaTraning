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
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 *
 * @author PA
 */
public class LockFileNIOExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
         File file = new File("C:\\Temp2\\test1\\io_sample.txt");     
         RandomAccessFile raf = new RandomAccessFile(file, "rw");
         
         FileChannel channel = raf.getChannel();
         FileLock lock = channel.tryLock(0, Long.MAX_VALUE , false);
         
         Desktop.getDesktop().edit(file);
         Thread.sleep(15*1000l);
         lock.release();
    }
}
