/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author PA
 */
public class HttpConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://coccoc.vn/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        Path path = Paths.get("test.html");
        try{
            InputStream inputStream = connection.getInputStream();
            
            OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            
            byte bytes[] = new byte[1024];
            int read = -1;
            while((read = inputStream.read(bytes)) !=-1 ){
                outputStream.write(bytes, 0, read);
            }
        }finally{
            Desktop.getDesktop().open(path.toFile());
        }
    }
}
