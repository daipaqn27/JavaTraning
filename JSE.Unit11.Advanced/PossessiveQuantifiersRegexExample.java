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
public class PossessiveQuantifiersRegexExample {
    public static void main(String[] args) {
        String text = "tôi là IPAD";
        Pattern pattern = Pattern.compile(".*+va");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("possessive--->" + matcher.find());
    }
}
