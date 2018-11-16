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
               <form col-md-2 pt-3>
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
                            <input type="radio" name="bezahlmethode" id="optionsRadios1" value="paypal" checked>   
                            PayPal
                        </label>
                       <label>
                            <input type="radio" name="bezahlmethode" id="optionsRadios1" value="bankeinzug" checked>   
                            Bankeinzug
                        </label>
                       <label>
                            <input type="radio" name="bezahlmethode" id="optionsRadios1" value="direktbezahlung" checked>   
                            Bezahlung in Unterkunft
                        </label>
                    </div>
                
                   <c:choose>
                       <c:when test="${bezahlmethode == true}">
                           <div class="form-group">
                                <input  type="text" class="form-control" id="name" placeholder="IBAN">
                           </div>
                       </c:when>
                   </c:choose>
               </form>
            </div>
        </div>
        
    <!--script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script-->
    <!--script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script-->
    <!--script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script-->
</jsp:attribute>
</template:mainTemplate>
