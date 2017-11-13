/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PA
 */
public class UpdateDataExample {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:derby:" + new File("./sampledb").getAbsolutePath()
                + ";create=true");
                PreparedStatement statement = connection.prepareStatement(
                        "update student set name = ? where id = ?");) 
        {
            statement.setString(1, "Le Thi Zz");
            statement.setInt(2, 2);
            statement.executeUpdate();
        }
    }
}
