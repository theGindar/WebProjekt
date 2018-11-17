/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick Guenther
 */
@WebServlet(urlPatterns = {"/CreateDataBase"})
public class CreateDataBase extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:hoteldatadb;create=true";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            createDB();
            fillDB();
        } catch (Exception ex) {
            System.out.println("DATABASE COULD NOT BE CREATED: " + ex);
        }
        
        
        
        
    }
    protected void createDB() throws Exception{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);
        try{
            connection.createStatement().execute( 
                "CREATE TABLE comments(commentID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), hotelID INTEGER NOT NULL, heading VARCHAR(200) NOT NULL, comment VARCHAR(2000) NOT NULL, rating INTEGER NOT NULL, CONSTRAINT primary_key PRIMARY KEY (commentID))"
            );
            System.out.println("Database comments created!");
        }catch(Exception ex){
            System.out.println("Database comments not created: " + ex);
        }
        try{
            connection.createStatement().execute( //Tabelle hotel
                "CREATE TABLE hotel(hotelID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), rating INTEGER, mainimg VARCHAR(50), price DOUBLE, description VARCHAR(2000), name VARCHAR(100), CONSTRAINT primary_key2 PRIMARY KEY (hotelID))"
            );
            System.out.println("Database hotel created!");
        }catch(Exception ex){
            System.out.println("Database hotel not created: " + ex);
        }
        try{
            connection.createStatement().execute( //Tabelle infocards
                "CREATE TABLE infocards(infocardID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), hotelID INTEGER, imgpath VARCHAR(50), text VARCHAR(2000), CONSTRAINT primary_key3 PRIMARY KEY (infocardID))"
            );
            System.out.println("Database infocards created!");
        }catch(Exception ex){
            System.out.println("Database infocards not created: " + ex);
        }
    }
    protected void fillDB() throws Exception{
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);
        try{
            connection.createStatement().execute(
                "INSERT INTO hotel (rating, mainimg, price, description, name) VALUES (3, 'hotel', 70.99, 'Beispielbeschreibung für das Hotel', 'Beispielhotel 1')"
            );
            System.out.println("Database hotel filled!");
        }catch(Exception ex){
            System.out.println("Database hotel not filled: " + ex);
        }
        try{
            connection.createStatement().execute(
                "INSERT INTO comments (hotelID, heading, comment, rating) VALUES (1, 'Beispielüberschrift für Bewertung 1', 'Das Hotel war super!', 5)"
            );
            connection.createStatement().execute(
                "INSERT INTO comments (hotelID, heading, comment, rating) VALUES (1, 'Beispielüberschrift für Bewertung 2', 'Das Hotel war mittelmäßig...', 2)"
            );
            System.out.println("Database comments filled!");
        }catch(Exception ex){
            System.out.println("Database comments not filled: " + ex);
        }
        try{
            connection.createStatement().execute(
                "INSERT INTO infocards (hotelID, imgpath, text) VALUES (1, 'hotelbsppic', 'Hier gibt es eine super Aussicht!')"
            );
            connection.createStatement().execute(
                "INSERT INTO infocards (hotelID, imgpath, text) VALUES (1, 'hotelbsppic', 'Es ist sehr schön hier!')"
            );
            connection.createStatement().execute(
                "INSERT INTO infocards (hotelID, imgpath, text) VALUES (1, 'hotelbsppic', 'Es gibt einen Pool!')"
            );
            System.out.println("Database infocards filled!");
        }catch(Exception ex){
            System.out.println("Database infocards not filled: " + ex);
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
        return "Short description";
    }// </editor-fold>

}
