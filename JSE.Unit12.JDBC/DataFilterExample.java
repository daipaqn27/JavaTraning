/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import com.sun.rowset.FilteredRowSetImpl;
import java.io.File;
import java.sql.SQLException;
import javax.sql.rowset.FilteredRowSet;

/**
 *
 * @author PA
 */
public class DataFilterExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        FilteredRowSet frs = new FilteredRowSetImpl();
        frs.setUrl("jdbc:derby:" + new File("./sampledb").getAbsolutePath());
        
        frs.setCommand("select * from student");
        frs.setFilter(new DataFilter());
        frs.execute();
        
        System.out.println("id\tname\t\tage");
        while(frs.next()){
            System.out.println(frs.getInt("id") + "\t" + frs.getString("name") + "\t" + frs.getInt("age"));
        }
    }
}
