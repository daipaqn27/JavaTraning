/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import com.sun.rowset.WebRowSetImpl;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author PA
 */
public class WebRowSetExample {
    public static void main(String[] args) throws SQLException, IOException {
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:derby:" + new File("./sampledb"));
                Statement statement = connection.createStatement();){
            ResultSet rs = statement.executeQuery(
                    "select * from student");
            
            WebRowSet wrs = new WebRowSetImpl();
            wrs.writeXml(rs, new FileWriter(new File("output.xml")));
            
            Desktop.getDesktop().open(new File("output.xml"));
        }
    }
}
