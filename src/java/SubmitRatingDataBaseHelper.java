
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick Guenther
 */
public class SubmitRatingDataBaseHelper extends DataBaseHelper{
    protected void writeRatingToDB(String hotelID,String heading, String comment, String rating){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
            Connection connection = DriverManager.getConnection("jdbc:derby:hoteldatadb;create=true");
            // Durch die Nutzung von Prepared Statements wird SQL Injections vorgebeugt.
            PreparedStatement ps = connection.prepareStatement("INSERT INTO comments (hotelID, heading, comment, rating) VALUES (?, ?, ?, ?)");
            ps.setString(1, hotelID);
            ps.setString(2, heading);
            ps.setString(3, comment);
            ps.setInt(4, Integer.parseInt(rating));
            ps.executeUpdate();
            System.out.println("successfully connected!");   
        }catch(Exception e){
            System.out.println("failed connecting to database... " + e);
            
        }
    }
}
