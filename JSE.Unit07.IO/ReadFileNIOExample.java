/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author PA
 */
public class ReadFileNIOExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        
        try{
            File file = new File("C:\\Temp2\\test1\\io_sample.txt");
            fileInputStream = new FileInputStream(file);
            fileChannel = fileInputStream.getChannel();
            
            long size = fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int)size);
            fileChannel.read(buffer);
            buffer.rewind();
            
            System.out.println(new String(buffer.array(), "utf8"));
        }finally{
            if(fileChannel != null) fileChannel.close();
            if(fileInputStream != null) fileInputStream.close();
        }
    }
}
