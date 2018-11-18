/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick Guenther
 */
@WebServlet(urlPatterns = {"/InfoPage"})
public class InfoPage extends HttpServlet {
    boolean dev = true;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        InfoPageDataBaseHelper dbHelper = new InfoPageDataBaseHelper();
        
        try (PrintWriter out = response.getWriter()) {
            int hotelID;
            /* Momentan befindet sich nur ein Eintrag in der Datenbank für das Hotel mit der ID 1. 
               Da die Searchpage verschiedene IDs schickt, wird für die Entwicklung jeder Request auf die ID 1 gestellt.
            */
            if(!dev){ 
                if(request.getParameter("hotelId") != null){
                    hotelID = Integer.parseInt(request.getParameter("hotelId"));
                }else{
                    hotelID = 1; // Wenn kein Hotel ausgewählt wird, wird das Hotel mit der ID 1 angezeigt --> für Entwicklung
                }
            }else{
                hotelID = 1;
            }
            //Erhält die Daten aus der Datenbank und übermittelt sie an die InfoPage.jsp
            request.setAttribute("hotelID", hotelID);
            request.setAttribute("price", dbHelper.getPriceFromDB(hotelID));
            request.setAttribute("hotelname", dbHelper.getHotelNameFromDB(hotelID));
            request.setAttribute("mainpicture", dbHelper.getMainImageFromDB(hotelID));
            request.setAttribute("rating", dbHelper.getMainRatingFromDB(hotelID));
            request.setAttribute("infocards", dbHelper.getInfoCardsFromDB(hotelID));
            request.setAttribute("ratingcards", dbHelper.getRatingCardsFromDB(hotelID));
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/InfoPage.jsp");
            dispatcher.forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "This servlet displays information of one hotel";
    }

}
