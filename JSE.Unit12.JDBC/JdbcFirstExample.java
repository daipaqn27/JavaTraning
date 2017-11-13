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
public class JdbcFirstExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver")
            .newInstance();
            connection = DriverManager.getConnection(
                "jdbc:derby:" + file.getAbsolutePath() + ";create=true");
            statement = connection.createStatement();
            
            System.out.println("db path " + file.getAbsolutePath());
            System.out.println("Create database success! ");
            
            String sql = "create table student("+
                    " id bigint primary key "+
                    " generated always as identity (start with 1, increment by 1),"+
                    " name varchar(1000), "+
                    " age integer default 20)";
            System.out.println(statement.execute(sql));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            statement.close();
            connection.close();
        }
    }
}
