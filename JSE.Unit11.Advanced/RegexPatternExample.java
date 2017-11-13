/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PA
 */
public class RegexPatternExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");
        
        String text = "1+1 bang 2";
        Matcher matcher = pattern.matcher(text);
        
//        System.out.println(matcher.find());
//        System.out.println("start = " + matcher.start() 
//                + " -end " + matcher.end());
//        System.out.println("value = " +text.substring(matcher.start(), matcher.end()));

        int start = 0;
        while(matcher.find(start)){
            start = matcher.start();
            int end = matcher.end();
            System.out.println("number: " + text.substring(matcher.start(), matcher.end()));
            start = end;
        }
    }
}
