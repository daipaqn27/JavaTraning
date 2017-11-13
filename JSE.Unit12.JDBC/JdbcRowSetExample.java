/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import com.sun.rowset.JdbcRowSetImpl;
import java.io.File;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author PA
 */
public class JdbcRowSetExample {

    public static void main(String[] args) throws SQLException {
        try (JdbcRowSet jdbcRowSet = new JdbcRowSetImpl();) {
            
            File file = new File("./sampledb");
            jdbcRowSet.setUrl("jdbc:derby:" + file);
            jdbcRowSet.setCommand("select * from student");
            jdbcRowSet.execute();
//
            while (jdbcRowSet.next()) {
                System.out.println(jdbcRowSet.getInt(1)
                        + "\t" + jdbcRowSet.getString("name"));
            }
            
            jdbcRowSet.first();
            jdbcRowSet.updateString("name", "Hoang Van X");
            jdbcRowSet.commit();
            
            jdbcRowSet.first();
            System.out.println(jdbcRowSet.getInt("id") + "\t" + jdbcRowSet.getString(2));
            
            jdbcRowSet.absolute(9);
            System.out.println(jdbcRowSet.getString("name") + ":" + jdbcRowSet.getInt("age"));
        }
    }
}
