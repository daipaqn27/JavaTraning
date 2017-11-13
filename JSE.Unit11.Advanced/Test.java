/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author PA
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    short value() default 0;
}

class TotalCalculator{
    int TOTAL =3;
    @Test(34)
    long getTotal(short value) {return TOTAL + value;}
    
    @Test(100)
    private void print(short value){
            System.out.println("gia tri them vao la " + value);
    }
}
