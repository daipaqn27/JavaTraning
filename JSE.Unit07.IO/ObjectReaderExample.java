/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7;

import com.sun.corba.se.impl.io.IIOPInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author PA
 */
public class ObjectReaderExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ObjectInputStream inputStream = null;
        File folder = new File("C:\\Temp2\\test1\\");
        inputStream = new ObjectInputStream(new FileInputStream(new File(folder, "my_object")));
        
        Object object = inputStream.readObject();
        Method method = object.getClass().getMethod("run", new Class[0]);
        method.invoke(object, new Object[0]);
        inputStream.close();
        
    }
}
