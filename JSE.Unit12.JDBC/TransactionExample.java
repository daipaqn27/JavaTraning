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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PA
 */
public class TransactionExample {
    public static void main(String[] args) throws SQLException {
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:derby:" + new File("./sampledb").getAbsolutePath());
                Statement statement = connection.createStatement();
                ){
//            System.out.println("record:" + statement.executeQuery(
//                    "select count(*) from student").next().getInt(1));
            connection.setAutoCommit(false);
            for(int i = 0; i <10; i++){
                String name = "Tran Van " + i;
                int age = 10 + i;
                statement.executeUpdate(
                        "insert into student(name, age) values" + 
                                "('"+ name +"',"+ age +")");
            }
            connection.rollback();
            
            connection.setAutoCommit(true);
            ResultSet rs = statement.executeQuery("select count(*) from student");
            if(rs.next()) System.out.println("total records = " + rs.getInt(1));
            
        }
    }
}
