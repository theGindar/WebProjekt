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
import javax.servlet.http.HttpSession;

/**
 *
 * @author D070483
 */
@WebServlet(urlPatterns = {
    "/AnswerPage"})

public class AnswerPageServlet extends HttpServlet {

@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");
        String vorname = (String) session.getAttribute("vorname");
        String stadt = (String) session.getAttribute("stadt");
        String strasse = (String) session.getAttribute("strasse");

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AnswerPage.jsp");
        dispatcher.forward(request, response);

        // Werte im Session Kontext entfernen, damit wir beim nächsten mal
        // wieder von vorne anfangen
        
        session.setAttribute("name", name);
        session.setAttribute("vorname", vorname);
        session.setAttribute("stadt", stadt);
        session.setAttribute("strasse", strasse);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = (String) request.getParameter("name");
        String vorname = (String) request.getAttribute("vorname");
        String stadt = (String) request.getAttribute("stadt");
        String strasse = (String) request.getAttribute("strasse");

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AnswerPage.jsp");
        dispatcher.forward(request, response);

        // Werte im Session Kontext entfernen, damit wir beim nächsten mal
        // wieder von vorne anfangen
        HttpSession session = request.getSession();
        
        session.setAttribute("name", name);
        session.setAttribute("vorname", vorname);
        session.setAttribute("stadt", stadt);
        session.setAttribute("strasse", strasse);
    }

}
