$(window).scroll(function() {
  Animate('fadein');
  console.log('es scrollt');
});

function Animate(name) {
  $('.fadein').each(function() {
    switch (name) {
      case 'fadein':
        AddClass(this, 'fade');
        break;
    }
    console.log('es scrollt2');
  });
};

function AddClass(object, name) {
  if (IsVisible(object)) {
    $(object).addClass(name);
  } else {
    $(object).removeClass(name);
  }
};

function IsVisible(object) {
  var viewport = $(window).scrollTop() + $(window).height();
  var offset = $(object).offset();
  offset.bottom = offset.top + $(object).outerHeight();
  return (!(viewport < (offset.top + 200) || $(window).scrollTop() > (offset.bottom -
    200)));
}

$("#jumptoratingbutton").click(function() {
  $([document.documentElement, document.body]).animate({
    scrollTop: $("#ratingsection").offset().top
  }, 500);
});
