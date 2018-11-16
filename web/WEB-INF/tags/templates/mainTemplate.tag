<%@tag pageEncoding="UTF-8"%>

<%@attribute name="headstart" fragment="true" %>
<%@attribute name="headend" fragment="true" %>
<%@attribute name="body" fragment="true" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:invoke fragment="headstart"/>
        <link rel="stylesheet" href="assets/css/mainTemplateStyles.css" />
        <jsp:invoke fragment="headend"/>

    </head>
    <body>

        <nav class="navbar fixed-top header">
            <div class="middle-header-div">
                <form action="/WebProjekt/" method="POST">
                    <button type="submit" class="header-title-pseudobutton btn actionbutton">Bucking.com</button>
                </form>
            </div>
        </nav>

        <jsp:invoke fragment="body"/>

    </body>
</html>