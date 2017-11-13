/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author PA
 */
public class PathExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        Path path1 = path.resolve("hanoijava.txt");
//        System.out.println("This is " + (Files.isDirectory(path)?"folder":"file"));
        
//        System.out.println(Files.exists(path));
        
//        Filter<Path> filter =  entry ->{ return Files.isDirectory(entry);};
        
        Charset charset = Charset.forName("utf8");
        try(BufferedReader reader = Files.newBufferedReader(path1, charset)){
            String line = null;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }catch(Exception e){ e.printStackTrace(); }
        
//        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path
//                //, 
//                //"*.{java,txt}"
//                //filter
//        )){
//            for (Path p :directoryStream) {
//                System.out.println(p.getFileName());
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }
}
