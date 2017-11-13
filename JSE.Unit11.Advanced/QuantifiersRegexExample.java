/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
/**
 *
 * @author PA
 */
public class QuantifiersRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("t+\\S+(\\S+)(.*)",
                //"t?\\S+(\\S+)(.*)",
                Pattern.UNICODE_CHARACTER_CLASS);
        
        String text = "tớ học java";
        Matcher matcher = pattern.matcher(text);
        System.out.println(text + "---->" + matcher.matches());
        
        text = "cậu học java";
        matcher = pattern.matcher(text);
        System.out.println(text + "---->" + matcher.matches());
        
        text = "tttôi học java";
        matcher = pattern.matcher(text);
        System.out.println(text + "--->" + matcher.matches());
        
        Regex regex = new Regex("t{2,}\\S+(\\S+)(.*)");
        Regex regex1 = new Regex("t{2,5}\\S+(\\S+)(.*)");
    }
}
