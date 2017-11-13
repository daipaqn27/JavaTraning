/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 *
 * @author PA
 */
public class DataAccessTest {
    public static void main(String[] args) throws SQLException {
        DataAccessLogic accessLogic = new DataAccessLogic();
//        List<String> names = accessLogic.loadNames(1);
//        names.forEach(System.out::println);
        System.out.println("total page = " + accessLogic.numberOfPage());
        
        IntStream.range(1, accessLogic.numberOfPage()+1).forEach(page -> {
            System.out.println("================" + page);
            
            List<String> names = null;
            try {
                names = accessLogic.loadNames(page);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            System.out.println(names);
        });
    }
}
