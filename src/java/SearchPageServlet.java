
import java.io.IOException;
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

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SearchPage.jsp");
        dispatcher.forward(request, response);

        // Werte im Session Kontext entfernen, damit wir beim nächsten mal
        // wieder von vorne anfangen
        HttpSession session = request.getSession();
        session.removeAttribute("vorname");
        session.removeAttribute("nachname");
        session.removeAttribute("fehlermeldungen");
        session.removeAttribute("showGreeting");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

        // Anfrage an eine JSP weiterleiten, um damit den HTML-Code
        // der Seite zu generieren
        String stadt = (String) request.getAttribute("stadt");
        String unterkunft = (String) request.getAttribute("unterkunft");
        String budget = (String) request.getAttribute("budget");
        
        HttpSession session = request.getSession();
        
        //überprüfen, ob Attribute im Feld in der Suche eingegeben werden können
        
        session.setAttribute("stadt", stadt);
        session.setAttribute("unterkunft", unterkunft);
        session.setAttribute("budget", budget);
        
        //session.removeAttribute("attribut");
    }
}
