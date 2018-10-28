
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
    protected ResultSet connectToDB(String query){
        //File dataBase = new File("../../database/HotelDataBase");
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelDataBase", "root", "1234"); 
            java.sql.Statement dbStatement = connection.createStatement();
            ResultSet rs = dbStatement.executeQuery(query);
            System.out.println("success");
            
            return rs;
        }catch(Exception e){
            System.out.println("fail...." + e);
            return null;
        }
    }
}
