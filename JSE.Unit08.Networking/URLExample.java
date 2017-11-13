/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author PA
 */
public class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        String link = "https://www.google.com.vn/search?q=hello";
        URL url = new URL(link);
        
        System.out.println("Protocol " + url.getProtocol());
        System.out.println("Port " + url.getPort());
        System.out.println("Query " + url.getQuery());
    }
}
