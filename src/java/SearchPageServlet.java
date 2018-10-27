
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {
    "",
    "/SearchPage"})
public class SearchPageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<String> stadtKategorien = this.getStadtKategorien();
        List<String> unterkunftKategorien = this.getUnterkunftKategorien();
        List<String> budgetKategorien = this.getBudgetKategorien();

        String chosenStadtKategorie = request.getParameter("chosenStadtKategorie");
        String chosenUnterkunftKategorie = request.getParameter("chosenUnterkunftKategorie");
        //int chosenBudgetKategorie = Integer.parseInt(request.getParameter("chosenBudgetKategorie"));
        int chosenBudgetKategorie = 20;
        
        List<Unterkunft> unterkuenfte = this.getUnterkuenfte(chosenStadtKategorie, chosenUnterkunftKategorie, chosenBudgetKategorie);

        request.setAttribute("stadtKategorien", stadtKategorien);
        request.setAttribute("unterkunftKategorien", unterkunftKategorien);
        request.setAttribute("budgetKategorien", budgetKategorien);

        request.setAttribute("unterkuenfte", unterkuenfte);

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SearchPage.jsp");
        dispatcher.forward(request, response);

        // Werte im Session Kontext entfernen, damit wir beim nächsten mal
        // wieder von vorne anfangen
        //HttpSession session = request.getSession();
        //session.removeAttribute("vorname");
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

    private ArrayList<Unterkunft> getUnterkuenfte(String chosenStadtKategorie, String chosenUnterkunftKategorie, int chosenBudgetKategorie) {
        ArrayList<Unterkunft> unterkuenfte = new ArrayList();

        unterkuenfte.add(new Unterkunft("Vollpension", chosenBudgetKategorie, "cool", 3, "Hotel am Graben", chosenStadtKategorie, chosenUnterkunftKategorie));
        unterkuenfte.add(new Unterkunft("Vollpension", 30, "cool", 3, "Hotel am Graben", "Grabenstadt", "Hotel"));
        unterkuenfte.add(new Unterkunft("Halbpension", 20, "sehr cool", 4, "Herberge am Graben", "Grabenstadt", "Herberge"));
        unterkuenfte.add(new Unterkunft("Vollpension", 50, "cool", 5, "Luxushotel für Schluffis", "Schluffistadt", "Hotel"));

        return unterkuenfte;
    }
}
