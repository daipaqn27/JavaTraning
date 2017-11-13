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
public class GreedyQuantifiersRegexExample {
    public static void main(String[] args) {
        String text = "xxxjavaxxxxxxjava";
        Pattern pattern = Pattern.compile(".*va", 
                Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("greedy---->" +matcher.find());
        System.out.println(text.subSequence(matcher.start(), matcher.end()));
        System.out.println("greedy---->" + matcher.find(matcher.end()));
    }
}
