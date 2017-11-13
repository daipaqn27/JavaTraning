/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author PA
 */
public class ReflectionTest{
    public static void explore(Object obj) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        Class<?> clazz = 
                obj.getClass();
        
        System.out.println("clazz name: " + clazz.getName());
        
        Field field = clazz.getDeclaredField("TOTAL");
        field.setAccessible(true);        
        //System.out.println("total value is " + field.get(obj));
        
//        field.set(obj, 25);        
//        System.out.println("total value 2 is " + field.get(obj));
        
//        Method method = clazz.getDeclaredMethod("getTotal", new Class[]{});
//        method.setAccessible(true);
//        System.out.println("method return value = " + method.invoke(obj, new Object[0]));
        
//        Method method = clazz.getDeclaredMethod("getTotal", new Class[]{int.class});
//        method.setAccessible(true);
//        System.out.println("method return value = " + method.invoke(obj, new Object[]{5}));
        
        Field modifierField = Field.class.getDeclaredField("modifiers");
        modifierField.setAccessible(true);
        modifierField.setInt(field, field.getModifiers()&~Modifier.FINAL);
        
        field.setInt(obj, 23);
        System.out.println("modified value of the total field is " +field.get(obj));
    }
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Object obj = TotalCalcultor.class.newInstance();
        explore(obj);
    }
}
