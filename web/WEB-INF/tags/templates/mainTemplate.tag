<%@tag pageEncoding="UTF-8"%>

<%@attribute name="head" fragment="true" %>
<%@attribute name="body" fragment="true" %>

<!DOCTYPE html>
<html>
    <head>
        
        <jsp:invoke fragment="head"/>

    </head>
    <body>

        <nav class="navbar fixed-top header">
            <div class="middle-header-div">
                <h1 class="header-title">Unterkunftsuche</h1>
            </div>
        </nav>

        <jsp:invoke fragment="body"/>

    </body>
</html>