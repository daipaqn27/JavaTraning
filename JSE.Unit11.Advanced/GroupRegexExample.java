/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.text.normalizer.UnicodeSet;

/**
 *
 * @author PA
 */
public class GroupRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+(\\S+)(\\.*)",
                Pattern.UNICODE_CHARACTER_CLASS);
        
        String text = "tôi học java";
        Matcher matcher = pattern.matcher(text);
        
        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }
}
