/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PA
 */
public class InsertDataExample {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver")
                    .newInstance();

            connection = DriverManager.getConnection(
                    "jdbc:derby:" + file.getAbsolutePath());
            statement = connection.createStatement();

            statement.execute("insert into student(name, age) values('Tran Van B', 20)");
            statement.execute("insert into student(name, age) values('Nguyen Van B', 21)");
            statement.execute("insert into student(name, age) values('Tran Thi B', 18)");
        } finally {
            statement.close();
            connection.close();
        }
    }
}
