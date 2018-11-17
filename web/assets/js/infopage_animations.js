$(document).ready(function() {
  $(window).scroll(function() {
    $('.fadein').each(function(i) {
      var bottom_of_object = $(this).offset().top + $(this).outerHeight();
      var bottom_of_window = $(window).scrollTop() + $(window).height();
      if (bottom_of_window > (bottom_of_object - 200)) {
        $(this).animate({
          'opacity': '1'
        }, 500);
      }
    });
  });
});

$("#jumptoratingbutton").click(function() {
  $([document.documentElement, document.body]).animate({
    scrollTop: $("#ratingsection").offset().top
  }, 500);
});
