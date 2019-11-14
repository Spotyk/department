var INPUT_NAME = "input[name=name]";
var INPUT_NEW_NAME = "#newName";

var INPUT_CREATE_NAME = "#createName";
var INPUT_CREATE_SALARY = "#createSalary";
var INPUT_CREATE_EMAIL = "#createEmail";
var INPUT_CREATE_DATE = "#createDate";
var INPUT_DEP_ID_WORKER = "#depId";
var INPUT_ID_WORKER = "#hiddenworkerId";

var INPUT_EDIT_NAME = "#editName";
var INPUT_EDIT_SALARY = "#editSalary";
var INPUT_EDIT_EMAIL = "#editEmail";
var INPUT_EDIT_DATE = "#editDate";
var INPUT_OLD_EMAIL = "#hiddenWorkerOldEmail";

var INPUT_DEP_ID = "#hiddenDepId";

var NAME_LABEL_SELECTOR = ".nameLabel";
var CORRECT_INPUT_SELECTOR = ".correct-input";
var NOT_CORRECT_INPUT_SELECTOR = ".not-correct-input";

function sendCreateRequest() {
    var name = $(INPUT_NEW_NAME).val();

    $.ajax({
        url: '/createDepartment',
        type: 'post',
        data: { name: name }
    }).statusCode({
        200: function() {
            window.location.replace(`http://${host}:${port}/departments`);
            closeCreateDepartment();
        },
        404: function(response) {
            printArrayFromString(response.responseText);
        }
    });
}

function sendCreateWorkerRequest() {
    var name = $(INPUT_CREATE_NAME).val();
    var salary = $(INPUT_CREATE_SALARY).val();
    var email = $(INPUT_CREATE_EMAIL).val();
    var date = $(INPUT_CREATE_DATE).val();
    var depId = $(INPUT_DEP_ID_WORKER).val();

    $.ajax({
        url: '/createWorker',
        type: 'post',
        data: { name: name, salary: salary, email: email, date: date, depId: depId }
    }).statusCode({
        200: function() {
            window.location.replace(`http://${host}:${port}/workers?depId=${depId}`);
            closeCreateDepartment();
        },
        404: function(response) {
            printArrayFromString(response.responseText);
        }
    });
}

function sendUpdateWorkerRequest() {
    var workerId = $(INPUT_ID_WORKER).val();
    var hiddenWorkerOldEmail = $(INPUT_OLD_EMAIL).val();
    var name = $(INPUT_EDIT_NAME).val();
    var salary = $(INPUT_EDIT_SALARY).val();
    var email = $(INPUT_EDIT_EMAIL).val();
    var date = $(INPUT_EDIT_DATE).val();
    var depId = $(INPUT_DEP_ID_WORKER).val();

    $.ajax({
        url: '/updateWorker',
        type: 'post',
        data: {
            name: name,
            salary: salary,
            email: email,
            date: date,
            depId: depId,
            workerId: workerId,
            hiddenWorkerOldEmail: hiddenWorkerOldEmail
        }
    }).statusCode({
        200: function() {
            window.location.replace(`http://${host}:${port}/workers?depId=${depId}`);
            closeEditDepartment();
        },
        404: function(response) {
            printArrayFromString(response.responseText);
        }
    });
}

function sendRequest() {
    var name = $(INPUT_NAME).val();
    var hiddenDepId = $(INPUT_DEP_ID).val();

    $.ajax({
        url: '/updateDepartment',
        type: 'post',
        data: { name: name, hiddenDepId: hiddenDepId }
    }).statusCode({
        200: function() {
            window.location.replace(`http://${host}:${port}/departments`);
            closeEditDepartment();
        },
        404: function(response) {
            printArrayFromString(response.responseText);
        }
    });

}

function printArrayFromString(string) {
    var array = string.split(/(\s+)/);
    array.forEach(function(element) {
        $(element).show();
    });
}