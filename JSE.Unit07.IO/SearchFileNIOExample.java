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
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PA
 */
public class SearchFileNIOExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Charset charset = Charset.forName("utf-8");
    Pattern pattern = Pattern.compile("s\\S", Pattern.CASE_INSENSITIVE);
    
        File file = new File("C:\\Temp2\\test1\\io_sample.txt");
        FileInputStream stream = new FileInputStream(file);
        FileChannel channel = stream.getChannel();
        ByteBuffer bb = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        CharBuffer cb = charset.decode(bb);
        
        Matcher matcher = pattern.matcher(cb);
        if(matcher.find()){
            System.out.println("Found at " + Integer.toString(matcher.start()));
            System.out.println("Value '" +cb.subSequence(0, 0)+"'");
        }else{
            System.out.println("Not found");
        }
    }
    
}
