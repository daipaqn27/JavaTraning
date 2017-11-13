/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author PA
 */
public class CopyFileNIOExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
         File file = new File("C:\\Temp2\\test1\\io_sample.txt");     
         File desFile = new File(file.getParentFile(),"sample2.txt");
         FileChannel srcChannel = null;
         FileChannel desChannel = null;
         
         srcChannel = new FileInputStream(file).getChannel();
         desChannel = new FileInputStream(desFile).getChannel();
         srcChannel.transferTo(0, srcChannel.size(), desChannel);
         
         Desktop.getDesktop().open(file.getParentFile());
    }
}
