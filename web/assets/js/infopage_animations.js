$("#jumptoratingbutton").click(function() {
    $([document.documentElement, document.body]).animate({
        scrollTop: $("#ratingsection").offset().top
    }, 500);
});
