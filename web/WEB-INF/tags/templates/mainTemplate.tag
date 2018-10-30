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
                <h1 class="header-title">Unterkunftsuche</h1>
            </div>
        </nav>

        <jsp:invoke fragment="body"/>

    </body>
</html>