/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import techmatter.java6.PrintMessage;

/**
 *
 * @author PA
 */
public class ObjectWriterExample {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File folder = new File("C:\\Temp2\\test1\\");
        ObjectOutputStream outputStream = null;
        
        FileOutputStream fileOutputStream = 
                new FileOutputStream(new File(folder, "my_object"));
        outputStream = new ObjectOutputStream(fileOutputStream);
        
//        PrintMessage printMessage = ;
        outputStream.writeObject(new PrintMessage("Can Noi Noi"));
        
        outputStream.close();
    }
}
