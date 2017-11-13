/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PA
 */
public class AnotationTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Method methods[] =  TotalCalculator.class.getDeclaredMethods();
        TotalCalculator obj = TotalCalculator.class.newInstance();
        
        Arrays.stream(methods).forEach(method -> {
            method.getAnnotation(Test.class);
            if(method.getAnnotation(Test.class) == null) return;
            
            System.out.println("test method " + method.getName());
            try {
                System.out.println(method.invoke(obj, new Object[]{method.getAnnotation(Test.class).value()}));
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AnotationTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AnotationTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(AnotationTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
