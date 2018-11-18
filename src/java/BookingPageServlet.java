/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author D070483
 */
@WebServlet(urlPatterns = {
    "/BookingPage"})

public class BookingPageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/BookingPage.jsp");
        dispatcher.forward(request, response);

        // Werte im Session Kontext entfernen, damit wir beim nächsten mal
        // wieder von vorne anfangen
        HttpSession session = request.getSession();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String hotelid = (String) request.getParameter("hotelId");
        String name = (String) request.getParameter("name");
        String vorname = (String) request.getParameter("vorname");
        String stadt = (String) request.getParameter("stadt");
        String strasse = (String) request.getParameter("strasse");


        HttpSession session = request.getSession();

        session.setAttribute("name", name);
        session.setAttribute("vorname", vorname);
        session.setAttribute("stadt", stadt);
        session.setAttribute("strasse", strasse);

        response.sendRedirect(request.getRequestURI());

    }

}
