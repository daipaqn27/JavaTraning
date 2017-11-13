/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab12;

import com.sun.rowset.CachedRowSetImpl;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author PA
 */
public class DataAccessLogic {
    private final static Logger LOGGER = Logger.getLogger(
            DataAccessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;
    int pageSize = 10;
    
    public DataAccessLogic() throws SQLException{
        this.connection = DriverManager.getConnection(
                "jdbc:derby:" + new File("./sampledb"));
        rowSet = new CachedRowSetImpl();
        rowSet.setCommand("select * from student");
        rowSet.execute(connection);
    }
    
    public void disconnect(){
        try{
            if(connection != null) connection.close();
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, e.toString());
        }
    }
    
    List<String> loadNames(int page) throws SQLException{
        List<String> names = new ArrayList<>();
        rowSet.setPageSize(pageSize);
        int start = (page - 1)*pageSize + 1;
        if(!rowSet.absolute(start)) return names;
        
        rowSet.previous();
        while(rowSet.next()){
            names.add(rowSet.getString("name"));
            if(names.size() >= pageSize) break;
        }
        return names;
    }
    
    int numberOfPage() throws SQLException{        
        try(Statement statement = connection.createStatement();){
            ResultSet rs = statement.executeQuery(
                    "select count(*) from student");
            if(!rs.next()) return 0;
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if(total%pageSize !=0 ) totalPage ++;
            return totalPage;
        }
    }
}
