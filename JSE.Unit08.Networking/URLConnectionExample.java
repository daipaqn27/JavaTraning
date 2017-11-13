/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

/**
 *
 * @author PA
 */
public class URLConnectionExample {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://coccoc.vn");
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream stream = connection.getInputStream();
        
        int read;
        byte[] bs = new byte[1024];
        while ((read = stream.read(bs)) != -1) {
            System.out.println(new String(bs, 0, read));
        }
    }
}
