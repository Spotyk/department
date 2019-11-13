
jQuery(function(){

    const EMPTY_FIELD_MESSAGE = "Empty field";
    const INVALID_EMAIL_MESSAGE = "Invalid email";
    const INVALID_LENGTH_MESSAGE = "Too large length. Max = 30";
    const INVALID_NAME_MESSAGE = "Invalid name";
    const INVALID_SURNAME_MESSAGE = "Invalid surname";

    jQuery( "#reg_form" ).submit(function() {
      var name = jQuery('#name').val();
      var surname = jQuery('#surname').val();
      var reg_email = jQuery('#reg_email').val();
      var reg_password = jQuery('#reg_password').val();
      var fields = [name, surname, reg_email, reg_password];
      var errors = ['#name_error','#surname_error','#email_error','#password_error'];

      var REGEX_LETTERS = /^[a-zA-Z]+$/;
      var REGEX_EMAIL = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

      errors.forEach(function(element) {
        jQuery(element).empty();
      });

      var isNoErrors = true;

      if(!REGEX_EMAIL.test(reg_email)){
        jQuery('#email_error').text(INVALID_EMAIL_MESSAGE);
        isNoErrors = false;
      }

      if(!REGEX_LETTERS.test(name)){
        jQuery('#name_error').text(INVALID_NAME_MESSAGE);
        isNoErrors = false;
      }

      if(!REGEX_LETTERS.test(surname)){
        jQuery('#surname_error').text(INVALID_SURNAME_MESSAGE);
        isNoErrors = false;
      }

      for (i = 0; i < fields.length; i++) {
        if(fields[i]===""){
         jQuery(errors[i]).text(EMPTY_FIELD_MESSAGE);
         isNoErrors = false;
        }
        if(fields[i].length>30){
         jQuery(errors[i]).text(INVALID_LENGTH_MESSAGE);
         isNoErrors = false;
        }
      }

      return isNoErrors;
    });
});