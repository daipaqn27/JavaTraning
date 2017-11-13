/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author PA
 */
public class RandomAccessFileExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp\\hanoijava2.txt");
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try(FileChannel fc = FileChannel.open(path, 
                StandardOpenOption.READ, StandardOpenOption.WRITE)){
            fc.read(buffer);
            System.out.println(new String(buffer.array()));
            
//            fc.position(0);
//            byte bytes[] = "Trần".getBytes();
//            fc.write(ByteBuffer.wrap(bytes));
        }
    }
}
