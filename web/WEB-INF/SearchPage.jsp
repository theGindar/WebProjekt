<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Unterkunftsuche</title>

        <!-- Bootstrap-Einbindung -->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/searchPageStyles.css">
    </head>

    <body>
        <nav class="navbar fixed-top header">
            <div class="middle-header-div">
                <h1 class="text-center">Unterkunftsuche</h1>
            </div>
        </nav>
        <div class="container-fluid p-3 mb-5 container-top">
            <form method="POST">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-2 pt-3">
                        <div class="form-group ">
                            <select name="chosenStadtKategorie" id="inputState" class="form-control">
                                <c:choose>  
                                    <c:when test="${chosenStadtKategorie == null}">  
                                        <option selected>Stadt</option>
                                        <c:forEach items="${stadtKategorien}" var="stadtKategorie">
                                            <option>${stadtKategorie}</option>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>  
                                        <option>Stadt</option>
                                        <c:forEach items="${stadtKategorien}" var="stadtKategorie">
                                            <c:choose>  
                                                <c:when test="${stadtKategorie == chosenStadtKategorie}">  
                                                    <option selected>${stadtKategorie}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>${stadtKategorie}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>  
                                    </c:otherwise>  
                                </c:choose>  
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2 pt-3">
                        <div class="form-group">
                            <select name="chosenUnterkunftKategorie" id="inputState" class="form-control">
                                <c:choose>  
                                    <c:when test="${chosenUnterkunftKategorie == null}">  
                                        <option selected>Unterkunft</option>
                                        <c:forEach items="${unterkunftKategorien}" var="unterkunftKategorie">
                                            <option>${unterkunftKategorie}</option>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>  
                                        <option>Unterkunft</option>
                                        <c:forEach items="${unterkunftKategorien}" var="unterkunftKategorie">
                                            <c:choose>  
                                                <c:when test="${unterkunftKategorie == chosenUnterkunftKategorie}">  
                                                    <option selected>${unterkunftKategorie}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>${unterkunftKategorie}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>  
                                    </c:otherwise>  
                                </c:choose>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2 pt-3">
                        <div class="form-group">
                            <select name="chosenBudgetKategorie" id="inputState" class="form-control">
                                <c:choose>  
                                    <c:when test="${chosenBudgetKategorie == null}">  
                                        <option selected>Budget</option>
                                        <c:forEach items="${budgetKategorien}" var="budgetKategorie">
                                            <option value="${budgetKategorie}">&lt;${budgetKategorie}€</option>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>  
                                        <option>Budget</option>
                                        <c:forEach items="${budgetKategorien}" var="budgetKategorie">
                                            <c:choose>  
                                                <c:when test="${budgetKategorie == chosenBudgetKategorie}">  
                                                    <option selected value="${budgetKategorie}">&lt;${budgetKategorie}€</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${budgetKategorie}">&lt;${budgetKategorie}€</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>  
                                    </c:otherwise>  
                                </c:choose>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-primary btn-block">Search</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="container-fluid">
            <div class="row">
                <c:forEach items="${unterkuenfte}" var="unterkunft">
                    <div class="col-md-12">
                        <div class="card my-3 mx-md-5 bg-light">
                            <div class="card-body">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSF7WtLzw4tyyOXKlgTYC1fDu4NTMyz3z1FDgtVMdXzuuJfFy6e0g" alt="Hotel 1" />
                                <h2>${unterkunft.getName()}:</h2>
                                <p>
                                    ${unterkunft.getBeschreibung()}
                                </p>
                                <footer>
                                    Bewertung: ${unterkunft.getBewertung()}/5 Sterne
                                </footer>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
