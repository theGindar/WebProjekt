$("#submit_rating_button").click(function() {
  const ratingrequest = new XMLHttpRequest();
  ratingrequest.open("POST",
    "http://localhost:8080/WebProjekt/SubmitRating");
  ratingrequest.setRequestHeader("Content-type",
    "application/x-www-form-urlencoded");

  ratingrequest.send("hotelID=" + $("#hotelID").val() + "&heading=" + $(
      "#heading_input").val() + "&comment=" + $("#comment_input").val() +
    "&rating=" + $("#rating_range").val());
  window.scrollTo(0, 0);
  location.reload();

});

$("#bookingbutton").click(function() {
  $("#id_form").submit();
});
