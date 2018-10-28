
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
    boolean dev = true; //bypass the database for testing the layout of jsp
    protected String getHotelNameFromDB(int hotelID){
        if(!dev){
            String query = "SELECT Name FROM ROOT.Hotel WHERE HotelID =" + String.valueOf(hotelID);
            ResultSet rs = this.readFromDB(query);

            try {
                rs.next();
                return rs.getString(1);
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }else{
            return "TestHotel1";
        }
    }
    protected int getMainRatingFromDB(int hotelID){
        if(!dev){
            return 0;
        }else{
            return 3;
        }
    }
    protected String getMainImageFromDB(int hotelID){
        if(!dev){
            return null;
        }else{
            return "hotel";
        }
        
    }
    protected String[][] getInfoCardsFromDB(int hotelID){
        if(!dev){
            return null;
        }else{
            String[][] s = new String[][]{
                {"hotelbsppic", "lorem ipsum1"},
                {"hotelbsppic", "lorem ipsum2"}};
            return s;
        }
    }
    protected String[][] getRatingCardsFromDB(int hotelID){
        if(!dev){
            return null;
        }else{
            String[][] s = new String[][]{
                {"Titel1", "lorem ipsum1", "4"},
                {"Titel2", "lorem ipsum2", "3"}};
            return s;
        }
    }
}
