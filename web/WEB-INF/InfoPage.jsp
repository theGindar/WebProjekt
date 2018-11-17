<%--
    Document   : InfoPage
    Created on : Oct 26, 2018, 12:50:57 PM
    Author     : Patrick Günther
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>viewhotel</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/infoPageStyles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md fixed-top">
        <div class="container-fluid"><a class="navbar-brand" href="#">Unterkunftsuche</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">First Item</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#">Second Item</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#">Third Item</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <%String imgname = request.getAttribute("mainpicture").toString();%>
    <section id="start" style='background-image: url("assets/img/<%=imgname%>.jpg");'>
        <div class="row" style="margin-right: 0px;">
            <div class="col">
                <%String mainheading = request.getAttribute("hotelname").toString();%>
                <h1 class="text-center" id="mainheading"> <%=mainheading%> </h1>
            </div>
        </div>
        <div class="row justify-content-center align-items-center align-content-center" id="ratingrow">
                <%int rating = Integer.parseInt(request.getAttribute("rating").toString());%>
                <% for(int i = 0; i < rating; i++){ %>
                    <div class="col offset-1"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
                <% } %>
                <% for(int i = 0; i < (5-rating); i++){ %>
                    <div class="col offset-1"><img src="assets/img/ratingicon_placeholder.png" class="ratingicon"></div>
                <% } %>
        </div>
        <div class="row" style="margin-top: 40px;">
            <div class="col-xl-6"><button class="btn btn-primary btn-lg" type="button" style="width: 100%;">Buchen</button></div>
            <div class="col-xl-6"><button id="jumptoratingbutton" class="btn btn-primary btn-lg" type="button" style="width: 100%;">Bewerten</button></div>
        </div>
    </section>
    <section class="secondarysection">
        <%
            ArrayList<String> infocards = (ArrayList<String>)request.getAttribute("infocards");
            Iterator infocardsIterator = infocards.iterator();
        %>
        <%while(infocardsIterator.hasNext()){%>
            <div class="card fadein">
                <div class="card-body">
                    <div class="row infocolumn">
                        <div class="col my-auto"><img class="rounded img-fluid infoimage" src="assets/img/<%=infocardsIterator.next()%>.jpg"></div>
                        <div class="col">
                            <p class="infoparagraph"><%=infocardsIterator.next()%></p>
                        </div>
                    </div>
                </div>
            </div>
        <% } %>
    </section>
    <section class="secondarysection">
        <%
            ArrayList<String> ratingcards = (ArrayList<String>)request.getAttribute("ratingcards");
            Iterator ratingcardsIterator = ratingcards.iterator();
        %>
        <%while(ratingcardsIterator.hasNext()){%>
            <div class="card fadein">
                <div class="card-body">
                    <h4 class="card-title"><%=ratingcardsIterator.next()%></h4>
                    <p class="card-text"><%=ratingcardsIterator.next()%></p>
                    <div class="row no-gutters align-content-center smallratingrow">
                        <%int commentrating = Integer.parseInt(String.valueOf(ratingcardsIterator.next()));%>
                        <%for(int j = 0; j < commentrating; j++){%>
                            <div class="col offset-1"><img src="assets/img/ratingicon.png" class="smallratingicon"></div>
                        <% } %>
                        <%for(int j = 0; j < (5-commentrating); j++){%>
                            <div class="col offset-1"><img src="assets/img/ratingicon_placeholder.png" class="smallratingicon"></div>
                        <% } %>
                    </div>
                </div>
            </div>
        <% } %>
    </section>
    <section id="ratingsection" class="fadein" style="background-color: #ffffff;margin: 30px;padding: 20px;">
        <div class="row">
            <div class="col">
                <h1>Bewerten</h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h2 class="commentdescription">Titel:</h2>
                <input type="text" id="heading_input" maxlength="200" style="background-size: auto;width: 100%;height: 50hv;">
                <h2 class="commentdescription">Text:</h2>
                <textarea id="comment_input" style="width: 100%;"></textarea></div>
        </div>
        <div class="row">
            <div class="col">
                <h2>Rating:</h2>
            </div>
        </div>
        <div class="row">
            <div class="col" style="margin-top: 20px;"><input id="rating_range" type="range" value="1" min="1" max="5" oninput="range_display.value = rating_range.value + 'x'"></div>
        </div>
        <div class="row">
            <div class="col">
                <output id="range_display" class="d-inline" style="font-size: 50px;">1x</output><img src="assets/img/ratingicon.png" style="width: 50px;"></div>
        </div>
        <div class="row">
            <div class="col" style="margin-top: 20px;"><button id="submit_rating_button" class="btn btn-primary btn-lg" type="submit">Button</button></div>
        </div>
    </section>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/infopage_animations.js"></script>
    <script src="assets/js/infopage_logic.js"></script>
</body>

</html>
