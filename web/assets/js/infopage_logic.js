$("#submit_rating_button").click(function() {
  const ratingrequest = new XMLHttpRequest();
  ratingrequest.open("POST",
    "http://localhost:8080/WebProjekt/SubmitRating");
  ratingrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded");

  ratingrequest.send("hotelID=" + $("#hotelID").val() + "&heading=" + $(
      "#heading_input").val() + "&comment=" + $("#comment_input").val() +
    "&rating=" + $("#rating_range").val());
});

$("#bookingbutton").click(function() {
  const ratingrequest = new XMLHttpRequest();
  ratingrequest.open("POST",
    "http://localhost:8080/WebProjekt/BookingPage");
  ratingrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded");

  ratingrequest.send("hotelID=" + $("#hotelID").val());
});
