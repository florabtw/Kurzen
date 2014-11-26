$(document).ready(function() {
    /* Submit form when user presses Enter */
    $('form input,url').keypress(function(e) {
        if (e.keyCode === 13) {
            e.preventDefault();
            kurzen();
        }
    });
});

function clearErrors() {
  $('.error').each(function(i, val) {
    val.remove();
  });
}

function kurzen() {
  clearErrors();

  var data = $('.url-form').serialize();
  $.ajax({
    url: '/',
    type: 'post',
    data: data,
    success: submitSuccess,
    error: submitError
  });
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

function submitError(req, stat, msg) {
  var error = $('<div/>')
                .addClass('error')
                .text(req.responseText);
  $('form').append(error);
}
