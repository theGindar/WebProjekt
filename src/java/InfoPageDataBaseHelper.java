
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick Guenther
 */
public class InfoPageDataBaseHelper extends DataBaseHelper {
    protected String getHotelNameFromDB(int hotelID){
        String query = "SELECT Name FROM ROOT.Hotel WHERE HotelID =" + String.valueOf(hotelID);
        ResultSet rs = this.connectToDB(query);
        
        try {
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    protected int getMainRatingFromDB(int hotelID){
        return 0;
    }
    protected String getMainImageFromDB(int hotelID){
        return null;
    }
    protected String[][] getInfoCardsFromDB(int hotelID){
        return null;
    }
    protected String[][] getRatingCardsFromDB(int hotelID){
        return null;
    }
}
