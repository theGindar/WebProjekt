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
        <link rel="stylesheet" href="assets/css/searchPageStyles.css">
    </jsp:attribute>

    <jsp:attribute name="body">
        <div class="container-fluid p-3 mb-5 container-top">
            <div class="row">
               <form col-md-2 pt-3 method="POST">
                   <!--  Normales  einzeiliges  Eingabefeld  -->
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
                 
                   <c:choose>
                        <c:when test="${1 == 1}">
                            <div class="form-group">
                                <input  type="text" class="form-control" id="iban" placeholder="IBAN">
                            </div>
                        </c:when>
                   </c:choose>
                </form>
            </div>
        </div>
        

</jsp:attribute>
</template:mainTemplate>
