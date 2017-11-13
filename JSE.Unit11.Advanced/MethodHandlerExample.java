/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab11;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author PA
 */
public class MethodHandlerExample {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh ;
//                = lookup.findVirtual(TotalCalcultor.class, "getTotal", 
//                MethodType.methodType(long.class, short.class));
        MethodHandle mh2 = lookup.findStatic(TotalCalcultor.class, "calculate", 
                MethodType.methodType(String.class));
        System.out.println(mh2.invokeExact());
        Object obj = TotalCalcultor.class.newInstance();
//        System.out.println(mh.invoke(obj, (short)23));
        
        obj = new Object();
        mh = lookup.findSetter(obj.getClass(), "TOTAL", int.class);
        mh.invoke(obj, 15);
        mh = lookup.findVirtual(TotalCalcultor.class, "getTotal", 
                MethodType.methodType(long.class, short.class));
        System.out.println(mh.invoke(obj, 23));
        
    }
}
