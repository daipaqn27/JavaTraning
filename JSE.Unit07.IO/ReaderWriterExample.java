/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author PA
 */
public class ReaderWriterExample {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Temp2\\test1\\io_sample.txt");        
        FileReader reader = null;
        try (FileWriter writer = new FileWriter(file, true)){
            writer.write("\r\n");
            writer.write("Tran Thi B");
            Desktop.getDesktop().open(file);
            
            reader = new FileReader(file);
            char[] buffer = new char[4 * 1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, read);
            }
            System.out.println(builder);
        } finally {
            reader.close();
        }
    }
}
