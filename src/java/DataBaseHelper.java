
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick Guenther
 */
public class DataBaseHelper {
    public ResultSet connectToDB(String statement){
        File dataBase = new File("../../database/HotelDataBase");
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby:"+dataBase.getCanonicalPath(), "root", "1234");
            java.sql.Statement dbStatement = connection.createStatement();
            ResultSet rs = dbStatement.executeQuery(statement);
            return rs;
        }catch(Exception e){
            return null;
        }
        
    }
}
