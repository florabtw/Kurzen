$(document).ready(function() {
    /* Submit form when user presses Enter */
    $('form input,url').keypress(function(event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            kurzen();
        }
    });
});

function kurzen() {
  var data = $('.url-form').serialize();
  $.post('/', data, submitSuccess);
}

function submitSuccess(data) {
  if ( $('.result').length ) {
    $('.result').text(data.url);
  } else {
    var url = $('<div/>').addClass('result');
    url.text(data.url);

    $('.container').append(url);
  }
}
