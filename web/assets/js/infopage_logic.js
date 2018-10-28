$("#submit_rating_button").click(function() {
  const ratingrequest = new XMLHttpRequest();
  ratingrequest.open("POST", "http://localhost:8080/WebProjekt/SubmitRating");
  ratingrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  ratingrequest.send("hotelID=1&heading=testheading1&comment=testcomment&rating=4");
  alert("toll1");
});
