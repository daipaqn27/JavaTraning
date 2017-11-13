/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PA
 */
public class BatchProcessingExample {

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:derby:" + new File("./sampledb").getAbsolutePath());
                Statement statement = connection.createStatement();) {
            
            for (int i = 0; i < 20; i++) {
                String name = "aaaaaa" + i;
                int age = 20 + i;
                statement.addBatch("insert into student(name, age)"
                        + " values('" + name + "'," + age + ")");
            }
            statement.executeBatch();
            
            ResultSet rs = statement.executeQuery("select count(*) from student");
            if (rs.next()) {
                System.out.println("total records = " + rs.getInt(1));
            }
        }
    }
}
