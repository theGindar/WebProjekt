
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
    // Verbindung zur Datenbank
    protected ResultSet readFromDB(String query, int limit){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
            Connection connection = DriverManager.getConnection("jdbc:derby:hoteldatadb;create=true");
            Statement dbStatement = connection.createStatement();
            // beschränkt die Anzahl der zurückgelieferten Datensätze
            if(limit != 0){
                dbStatement.setMaxRows(limit);
            }
            ResultSet rs = dbStatement.executeQuery(query);
            System.out.println("successfully connected!"); 
            return rs;
        }catch(Exception e){
            System.out.println("failed connecting to database... " + e);
            return null;
        }
    }
}
