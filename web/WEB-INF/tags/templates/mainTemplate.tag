<%@tag pageEncoding="UTF-8"%>

<!-- Definition der Platzhalter, die unten verwendet werden. -->
<!-- fragment="true" bedeutet, dass ein ganzes Stück HTML-Code eingefügt wird. -->
<!-- Andernfalls wird nur ein kurzer Textausschnitt ohne HTML-Code übernommen. -->
<%@attribute name="title"%>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">

        <!-- Platzhalter für den Titel -->
        <title>${title}</title>

        <link rel="stylesheet" href="style.css" />
        <script src="script.js"></script>
    </head>
    <body>
        <nav>
            <!-- Nochmal der Platzhalter für den Titel -->
            <h1>${title}</h1>

            <ul>
                <li>
                    <a href="index.jsp">Startseite</a>
                </li>
                <li>
                    <a href="firmenportrait.jsp">Firmenportrait</a>
                </li>
                …
            </ul>
        </nav>

        <main>
            <!-- Platzhalter für den Body-Inhalt -->
            <jsp:invoke fragment="body"/>
        </main>
    </body>
</html>