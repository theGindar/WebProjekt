/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trybeforeyoubuy
 */
public class SubmitRatingDataBaseHelper extends DataBaseHelper{
    protected void writeRatingToDB(String hotelID,String heading, String comment, String rating){
        String saveHotelID = hotelID;
        String saveHeading = heading;
        String saveComment = comment;
        String saveRating = String.valueOf(rating);
        String commentID = "1";
          
        String query = "INSERT INTO ROOT.comments (hotelID, comment, rating, heading, commentID) VALUES (" + saveHotelID + ", '"+ saveComment + "', " + saveRating + ", '" + saveHeading + "', " + "1" + ")";
        System.out.println("QUERY: " + query);
        this.writeToDB(query);
    }
}
