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
    "",
    "/StartPage"})
public class StartPageServlet extends HttpServlet {   
    private ArrayListDatabaseManager dbManager = new ArrayListDatabaseManager();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<String> stadtKategorien = this.getStadtKategorien();
        List<String> unterkunftKategorien = this.getUnterkunftKategorien();
        List<String> budgetKategorien = this.getBudgetKategorien();

        HttpSession session = request.getSession();
        
        //Attribute aus der Session auslesen
        String chosenStadtKategorie = (String) session.getAttribute("chosenStadtKategorie");
        String chosenUnterkunftKategorie = (String) session.getAttribute("chosenUnterkunftKategorie");
        String chosenBudgetKategorie = (String) session.getAttribute("chosenBudgetKategorie");
        
        //ausgefilterte Unterkünfte auslesen (intern durch DBmanager)
        List<Unterkunft> unterkuenfte = this.getUnterkuenfte(chosenStadtKategorie, chosenUnterkunftKategorie, chosenBudgetKategorie);

        //Attribute im Request setzen
        request.setAttribute("stadtKategorien", stadtKategorien);
        request.setAttribute("unterkunftKategorien", unterkunftKategorien);
        request.setAttribute("budgetKategorien", budgetKategorien);

        request.setAttribute("unterkuenfte", unterkuenfte);

        // Anfrage an die JSP weiterleiten, um damit den HTML-Code der Seite zu generieren
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/StartPage.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        String chosenStadtKategorie = (String) request.getParameter("chosenStadtKategorie");
        String chosenUnterkunftKategorie = (String) request.getParameter("chosenUnterkunftKategorie");
        String chosenBudgetKategorie = (String) request.getParameter("chosenBudgetKategorie");

        HttpSession session = request.getSession();

        //überprüfen, ob Attribute im Feld in der Suche eingegeben werden können
        session.setAttribute("chosenStadtKategorie", chosenStadtKategorie);
        session.setAttribute("chosenUnterkunftKategorie", chosenUnterkunftKategorie);
        session.setAttribute("chosenBudgetKategorie", chosenBudgetKategorie);

        response.sendRedirect(request.getRequestURI());
    }

    private ArrayList<String> getStadtKategorien() {
        ArrayList<String> stadtKategorien = new ArrayList();

        stadtKategorien.add("Bremen");
        stadtKategorien.add("Berlin");
        stadtKategorien.add("Erfurt");
        stadtKategorien.add("Leipzig");
        stadtKategorien.add("Dessau");
        stadtKategorien.add("Aachen");

        return stadtKategorien;
    }

    private ArrayList<String> getUnterkunftKategorien() {
        ArrayList<String> unterkunftKategorien = new ArrayList();

        unterkunftKategorien.add("Jugendherberge");
        unterkunftKategorien.add("Hostel");
        unterkunftKategorien.add("Luxushotel");

        return unterkunftKategorien;
    }

    private ArrayList<String> getBudgetKategorien() {
        ArrayList<String> budgetKategorien = new ArrayList();

        budgetKategorien.add("20");
        budgetKategorien.add("25");
        budgetKategorien.add("200");

        return budgetKategorien;
    }

    private ArrayList<Unterkunft> getUnterkuenfte(String chosenStadtKategorie, String chosenUnterkunftKategorie, String chosenBudgetKategorie) {
        return dbManager.getFilteredUnterkuenfte(chosenStadtKategorie, chosenUnterkunftKategorie, chosenBudgetKategorie);
    }
}
