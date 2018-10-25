<%--
    Document   : InfoPage
    Created on : Oct 14, 2018, 3:26:07 PM
    Author     : trybeforeyoubuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>viewhotel</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="assets/css/styles.min.css">-->
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md fixed-top">
        <div class="container-fluid"><a class="navbar-brand" href="#">Brand</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
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
    <section id="start">
        <div class="row">
            <div class="col">
                <h1 class="text-center myheading" id="mainheading">Heading</h1>
            </div>
        </div>
        <div class="row justify-content-center align-items-center align-content-center" id="ratingrow">
            <% for(int i = 0; i < Integer.parseInt(request.getAttribute("rating").toString()); i++){ %>
                <div class="col offset-1"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
            <% } %>
        </div>
    </section>
    <section class="info">
        <div class="row">
            <div class="col"><img src="assets/img/hotelbsppic.jpg" class="infoimage"></div>
            <div class="col">
                <p class="infoparagraph">111111111Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam</p>
            </div>
        </div>
        <div></div>
    </section>
    <section style="margin: 30px;">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Title</h4>
                <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                <div class="row justify-content-center align-items-center align-content-center" id="ratingrow">
                    <div class="col offset-1" style="margin: 0px;"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
                    <div class="col offset-1" style="margin: 0px;"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
                    <div class="col offset-1" style="margin: 0px;"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
                    <div class="col offset-1" style="margin: 0px;"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
                    <div class="col offset-1" style="margin: 0px;"><img src="assets/img/ratingicon.png" class="ratingicon"></div>
                </div>
            </div>
        </div>
    </section>
    <section style="background-color: #ffffff;margin: 30px;">
        <div class="row">
            <div class="col">
                <h1>Bewerten</h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h2 class="commentdescription">Titel:</h2><input type="text" maxlength="2000" style="background-size: auto;width: 100%;height: 50hv;">
                <h2 class="commentdescription">Text:</h2><input type="text" maxlength="2000" style="background-size: auto;width: 100%;height: 50hv;"></div>
        </div>
        <div class="row">
            <div class="col">
                <h2>Rating:</h2>
            </div>
        </div>
        <div class="row">
            <div class="col"><input type="range" value="1" min="1" max="5"></div>
        </div>
    </section>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
