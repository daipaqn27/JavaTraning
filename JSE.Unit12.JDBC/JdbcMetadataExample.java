/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PA
 */
public class JdbcMetadataExample {
    public static void main(String[] args) throws SQLException {
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:derby:" + new File("./sampledb").getAbsolutePath());){
            DatabaseMetaData metaData = connection.getMetaData();
            
            System.out.println("db version " + metaData.getDatabaseMajorVersion());
            System.out.println("driver name " + metaData.getDriverName());
        }
    }
}
