<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>

<!DOCTYPE html>
<template:mainTemplate>
    <jsp:attribute name="headstart">
        <meta charset="utf-8" />
        <title>Buchen</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    </jsp:attribute>

    <jsp:attribute name="headend">
        <link rel="stylesheet" href="assets/css/bookingPageStyles.css">
    </jsp:attribute>

    <jsp:attribute name="body">
        <div class="container-fluid p-3 mb-3 container-top">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-12">
                    <div class="card my-3 mx-md-5 bg-light">
                        <div class="card-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="container-fluid">
                                            <div class="row">
                                                <div class="col-12 card-title-frame">
                                                    <h2 class="card-title">Aquis Grana City Hotel</h2>
                                                </div>
                                                <div class="card-pic-container col-sm-4 col-10">
                                                    <div class="card-pic-frame">
                                                        <img class="card-picture w-100" src="assets/img/hotel.jpg" alt="Hotel 1" />                               
                                                    </div>
                                                </div>
                                                <div class="card-content-frame col-sm-8">
                                                    <div class="col-12">
                                                        <p class="card-text">Dieses Hotel befindet sich nur 200 m vom Aachener Dom entfernt und bietet geräumige Zimmer, ein tägliches Frühstücksbuffet und eine Tiefgarage. Die Bar und die Rezeption sind rund um die Uhr geöffnet.</p>
                                                    </div>
                                                    <div class="card-rating-frame col-12">
                                                        <p class="card-text card-text-bewertung">Bewertung: 4 Sterne</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 container-fluid">
                                        <div class="card-prize-buttons-row row">
                                            <div class="card-price-frame col-6 col-md-12">
                                                <h1 class="card-prize-text">20€</h1>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
             
        <div class="container-fluid p-3 mb-5 container-top">
            <div class="row align-items-center justify-content-center">
               <form col-md-2 pt-3 action="/WebProjekt/AnswerPage "method="post">
                   <!--  Normales  einzeiliges  Eingabefeld  -->
                   <div>${hotelId}</div>
                    <div class="form-group">
                        <input  type="text" class="form-control" id="name" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <input  type="text" class="form-control" id="vorname" placeholder="Vorname">
                    </div>
                   <div class="form-group">
                        <input  type="text" class="form-control" id="stadt" placeholder="PLZ, Wohnort">
                    </div>
                   <div class="form-group">
                        <input  type="text" class="form-control" id="strasse" placeholder="Straße, Hausnummer">
                    </div>
                   <div class="radio">
                        <label>
                            <input type="radio" name="bezahlmethode" id="paypal" value="paypal" checked>   
                            PayPal
                        </label>
                       <label>
                            <input type="radio" name="bezahlmethode" id="bankeinzug" value="bankeinzug" checked>   
                            Bankeinzug
                        </label>
                       <label>
                            <input type="radio" name="bezahlmethode" id="direktbezahlung" value="direktbezahlung" checked>   
                            Bezahlung in Unterkunft
                        </label>
                    </div>
                   <div class="card-button-frame col-12">
                       <button type="submit" class="btn btn-primary btn-block actionbutton">Buchen</button>
                   </div>    
                      
                </form>
            </div>
        </div>
        

</jsp:attribute>
</template:mainTemplate>
