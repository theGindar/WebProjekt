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
        <link rel="stylesheet" href="assets/css/bookingPageStyles_1.css">
    </jsp:attribute>

    <jsp:attribute name="body">
        <div class="container-fluid p-3 mb-5 container-top">
            <div class="row align-items-center justify-content-center">
                <form method="get">
                    <div>Buchung erfolgreich!</div>
                    <div>${name}</div>
                    <div>${vorname}</div>
                    <div>${stadt}</div>
                    <div>${strasse}</div>
                </form>
            </div>
        </div>
    </jsp:attribute>
</template:mainTemplate>
