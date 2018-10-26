<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <title>Unterkunftsuche</title>

  <!-- Bootstrap-Einbindung -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>

<body>
  <div class="container-fluid bg-light p-3 mb-5">
    <div class="row align-items-center justify-content-center">
      <div class="col-md-2 pt-3">
        <div class="form-group ">
          <select id="inputState" class="form-control">
            <option selected>Stadt</option>
            <option>Erfurt</option>
            <option>Leipzig</option>
            <option>Dessau</option>
            <option>Aachen</option>
          </select>
        </div>
      </div>
      <div class="col-md-2 pt-3">
        <div class="form-group">
          <select id="inputState" class="form-control">
            <option selected>Unterkunft</option>
            <option>Hostel</option>
            <option>Hotel</option>
            <option>Ferienhaus</option>
            <option>Jugendherberge</option>
          </select>
        </div>
      </div>
      <div class="col-md-2 pt-3">
        <div class="form-group">
          <select id="inputState" class="form-control">
            <option selected>Budget</option>
            <option>&lt;20€</option>
            <option>&lt;30€</option>
            <option>&lt;40€</option>
            <option>&lt;100€</option>
          </select>
        </div>
      </div>
      <div class="col-md-2">
        <button type="submit" class="btn btn-primary btn-block">Search</button>
      </div>
    </div>
  </div>

  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="card my-3 mx-md-5 bg-light">
          <div class="card-body">
            <img class="" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSF7WtLzw4tyyOXKlgTYC1fDu4NTMyz3z1FDgtVMdXzuuJfFy6e0g" alt="Hotel 1" />
            <h2>Hotel 1</h2>
            <p>
              Text des Hotels
            </p>
            <footer>
              Bewertung etc
            </footer>
          </div>
        </div>
      </div>
      <div class="col-md-12">
        <div class="card my-3 mx-md-5 bg-light">
          <div class="card-body">
            <h2>Hotel 1</h2>
            <p>
              Text des Hotels
            </p>
            <footer>
              Bewertung etc
            </footer>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>
