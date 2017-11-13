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
public class CreateStoredProcedureExample {
    public static void main(String[] args) throws SQLException {
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:derby:" + new File("./sampledb").getAbsolutePath());
                Statement statement = connection.createStatement();){
            statement.executeUpdate("create procedure getAge("
                    + "stream_name varchar(255), "
                    + "out age int)"
                    + " parameter style java reads "
                    + " sql data language java external name "
                    + " 'jdbc.DbFunction.getAge'");
            System.out.println("done");
        }
    }
}
