/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7nio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author PA
 */
public class WritePathExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp\\hanoijava2.txt");
//        path.resolve("hanoijava2.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(path, 
                Charset.forName("utf8"),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            for(int i = 0; i < 10; i++){
                writer.write("nguyen van " + i +"\r\n");
            }
        }catch(Exception e){ e.printStackTrace(); }
    }
}
