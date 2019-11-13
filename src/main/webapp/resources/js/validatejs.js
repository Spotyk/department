
   var REGEX_LETTERS = /^[a-zA-Z]+$/;
   var REGEX_EMAIL = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

   const ERROR_EMPTY_FIELD_KEY = "emptyField";
   const ERROR_USER_EXIST_KEY = "userExist";
   const ERROR_INVALID_EMAIL_KEY = "invalidEmail";
   const ERROR_LARGE_LENGTH = "largeLength";
   const ERROR_INVALID_NAME = "invalidName";
   const ERROR_INVALID_SURNAME = "invalidSurname";

   let errorMessages = new Map();
   errorMessages.set(ERROR_EMPTY_FIELD_KEY, "This field is empty");
   errorMessages.set(ERROR_USER_EXIST_KEY, "This user already exists");
   errorMessages.set(ERROR_INVALID_EMAIL_KEY, "Invalid email");
   errorMessages.set(ERROR_LARGE_LENGTH, "Too large length. Max symbols 30");
   errorMessages.set(ERROR_INVALID_NAME, "Invalid name");
   errorMessages.set(ERROR_INVALID_SURNAME, "Invalid surname");

 function validateRegistration(){

     let allErrors = new Map();

     clearFields();
     var name = document.getElementById('name').value;
     var surname = document.getElementById('surname').value;
     var reg_email = document.getElementById('reg_email').value;
     var reg_password = document.getElementById('reg_password').value;
     var fields = [name, surname, reg_email, reg_password];
     var fieldsErrors = ["name_error", "surname_error", "email_error", "password_error"];


     if(!REGEX_EMAIL.test(reg_email)){
          allErrors.set("email_error", errorMessages.get(ERROR_INVALID_EMAIL_KEY));
     }

     if(!REGEX_LETTERS.test(name)){
          allErrors.set("name_error", errorMessages.get(ERROR_INVALID_NAME));
     }

     if(!REGEX_LETTERS.test(surname)){
          allErrors.set("surname_error", errorMessages.get(ERROR_INVALID_SURNAME));
     }

     for (i = 0; i < fields.length; i++) {
       if(fields[i]===""){
        allErrors.set(fieldsErrors[i], errorMessages.get(ERROR_EMPTY_FIELD_KEY));
       }
       if(fields[i].length>30){
        allErrors.set(fieldsErrors[i], errorMessages.get(ERROR_LARGE_LENGTH));
       }
     }

    if(allErrors.size === 0){
        return true;
    } else {
        for (i = 0; i < fieldsErrors.length; i++) {
          if(allErrors.get(fieldsErrors[i])!==undefined){
            document.getElementById(fieldsErrors[i]).innerHTML = allErrors.get(fieldsErrors[i]);
          }
        }
        return false;
    }
 }

function clearFields(){
     document.getElementById('name_error').innerHTML = "";
     document.getElementById('surname_error').innerHTML = "";
     document.getElementById('email_error').innerHTML = "";
     document.getElementById('password_error').innerHTML = "";
}