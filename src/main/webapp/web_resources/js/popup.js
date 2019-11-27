var DUPLICATE_NAME = ".duplicateName";
var DUPLICATE_EMAIL = ".duplicateEmail";
var NOT_VALID_NAME = ".notValidName";
var NOT_VALID_EMAIL = ".notValidEmail";
var NOT_VALID_DATE = ".notValidDate";
var NOT_VALID_NUMBER = ".notValidNumber";

function createWorker() {
    hideIfShown();
    let $recallPopUP = $(".modal-create");
    $recallPopUP.addClass("show-modal");
    savedPosition = $(window).scrollTop();
    fixBodyPosition();
}

function editWorker(id, salary, name, email, date) {
    hideIfShown();
    $("#hiddenworkerId").val(`${id}`);
    $("#hiddenWorkerOldEmail").val(`${email}`);
    $("#editName").val(`${name}`);
    $("#editSalary").val(`${salary}`);
    $("#editDate").val(`${date}`);
    $("#editEmail").val(`${email}`);
    let $recallPopUP = $(".modal-edit");
    $recallPopUP.addClass("show-modal");
    savedPosition = $(window).scrollTop();
    fixBodyPosition();
}

function createDepartment() {
    hideIfShown();
    let $createPopUP = $(".modal-create");
    $createPopUP.addClass("show-modal");
    savedPosition = $(window).scrollTop();
    fixBodyPosition();
}
function hideIfShown(){
    $(DUPLICATE_NAME).hide();
    $(DUPLICATE_EMAIL).hide();
    $(NOT_VALID_NAME).hide();
    $(NOT_VALID_NAME).hide();
    $(NOT_VALID_EMAIL).hide();
    $(NOT_VALID_DATE).hide();
    $(NOT_VALID_NUMBER).hide();
}