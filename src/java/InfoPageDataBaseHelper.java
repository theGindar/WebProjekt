
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
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
    boolean dev = false; //bypass the database for testing the layout of jsp
    protected String getHotelNameFromDB(int hotelID){
        if(!dev){
            String query = "SELECT Name FROM hotel WHERE HotelID =" + String.valueOf(hotelID);
            ResultSet rs = this.readFromDB(query, 0);

            try {
                rs.next();
                return rs.getString(1);
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }else{
           return "testheading";
        }
    }
    protected int getMainRatingFromDB(int hotelID){
        if(!dev){
            String query = "SELECT rating FROM hotel WHERE hotelID=" + String.valueOf(hotelID);
            ResultSet rs = this.readFromDB(query, 0);

            try {
                rs.next();
                return Integer.parseInt(rs.getString(1));
            } catch (SQLException ex) {
                System.out.println(ex);
                return 0;
            }
        }else{
            return 3;
        }
    }
    protected String getMainImageFromDB(int hotelID){
        if(!dev){
            String query = "SELECT mainimg FROM hotel WHERE hotelID=" + String.valueOf(hotelID);
            ResultSet rs = this.readFromDB(query, 0);

            try {
                rs.next();
                return rs.getString(1);
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }else{
            return "hotel";
        }   
    }
    protected String getPriceFromDB(int hotelID){
        if(!dev){
            String query = "SELECT price FROM hotel WHERE hotelID=" + String.valueOf(hotelID);
            ResultSet rs = this.readFromDB(query, 0);

            try {
                rs.next();
                return rs.getString(1);
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }else{
            return "hotel";
        }   
    }
    protected ArrayList<String> getInfoCardsFromDB(int hotelID){
        if(!dev){
            String query = "SELECT imgpath, text FROM infocards WHERE hotelID=" + String.valueOf(hotelID);
            ResultSet rs = this.readFromDB(query, 0);
            try {
                ArrayList<String> resultList = new ArrayList<String>();
                while(rs.next()){
                    for(int i = 1; i <=2; i++){
                        resultList.add(rs.getString(i));
                    }
                }
                return resultList;
                
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }else{
            ArrayList<String> resultList = new ArrayList<String>();
            for(int i = 0; i<2; i++){
                resultList.add("hotelbsppic");
                resultList.add("lorem ipsum" + i);
            }
            
            return resultList;
        }
    }
    protected ArrayList<String>getRatingCardsFromDB(int hotelID){
        if(!dev){
            String query = "SELECT heading, comment, rating FROM comments WHERE hotelID=" + String.valueOf(hotelID) + "ORDER BY commentID DESC";
            ResultSet rs = this.readFromDB(query, 5);
            try {
                ArrayList<String> resultList = new ArrayList<String>();
                while(rs.next()){
                    for(int i = 1; i <=3; i++){
                        resultList.add(rs.getString(i));
                    }
                }
                return resultList;
                
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            }
        }else{
            ArrayList<String> resultList = new ArrayList<String>();
            for(int i = 0; i<2; i++){
                resultList.add("Titel");
                resultList.add("lorem ipsum" + i);
                resultList.add("3");
            }
            
            return resultList;
        }
    }
}
