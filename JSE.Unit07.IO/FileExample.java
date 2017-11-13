/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author PA
 */
public class FileExample {
    
    private static long getSize(File file){
        if(file.isFile()) return file.length();
        File files[] = file.listFiles();
        //int length = 0;
        AtomicLong length = new AtomicLong(0);
        Arrays.stream(files).forEach(fileItem -> {
            length.getAndSet(length.longValue() + 
                    (fileItem.isDirectory()?getSize(fileItem):fileItem.length()));
//            length += fileItem.length();
        });
//        for(int i = 0; i < files.length; i++){
//            if(files[i].isDirectory()){
//                length += getSize(files[i]);
//                   continue;
//            }
//            length += files[i].length();
//        }
        
        return length.longValue();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("This is" + (file.isFile() ? "file" : "folder") + "!");
        System.out.println("Size: " + getSize(file)/(1024*1024) + "MB");
        
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
        }
        for (File f : files) {
            System.out.println(f.getName() + ":" + f.length() + " bytes");
        }
    }
}
