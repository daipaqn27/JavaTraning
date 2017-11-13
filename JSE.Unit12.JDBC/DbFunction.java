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
public class DbFunction {
    public static void getAge(String name, int ages[]) throws SQLException {
        try(Connection connection = DriverManager.getConnection(
                "jdbc:derby:" + new File("./sampledb").getAbsolutePath());
                Statement statement = connection.createStatement();){
            ResultSet rs = statement.executeQuery(
                    "select max(age) from student where name like '%"+ name +"%'");
            ages[0] = rs.next()?rs.getInt(1):-1;
            
        }
    }
    
    public static void main(String[] args) throws SQLException {
        int ages[] = new int[1];
        getAge("Thi Z", ages);
        System.out.println(ages[0]);
    }
}
