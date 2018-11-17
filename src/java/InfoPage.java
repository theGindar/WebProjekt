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
            if(request.getParameter("hotelID") != null){
                hotelID = Integer.parseInt(request.getParameter("hotelID"));
            }else{
                hotelID = 1; // ändern
            }
              // preis nicht vergessen !!!!!!!!!!
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
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet displays information of one hotel";
    }// </editor-fold>

}
