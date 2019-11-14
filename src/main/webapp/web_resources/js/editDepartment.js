var modal = document.getElementById('popupEdit');
var modalCreate = document.getElementById('popupCreate');

window.onclick = function(event) {
    if (event.target == modal) {
        closeEditDepartment();
    }
    if (event.target == modalCreate) {
        closeCreateDepartment();
    }
}

$(document).keyup(function(event) {
    if (event.keyCode == 27) {
        closeEditDepartment();
        closeCreateDepartment();
    }
});

var savedPosition = 0;

function editDepartment(id, name) {
    $("#hiddenDepId").val(`${id}`);
    $("#name").val(`${name}`);
    let $recallPopUP = $(".modal-edit");
    $recallPopUP.addClass("show-modal");
    savedPosition = $(window).scrollTop();
    fixBodyPosition();
}

function fixBodyPosition() {
    var offsetY = window.pageYOffset;
    $('body').addClass("fixed-body-position");
}

function unFixBodyPosition() {
    $('body').removeClass("fixed-body-position");
}

function closeEditDepartment() {
    let $recallPopUP = $(".modal-edit");
    $recallPopUP.removeClass("show-modal");
    unFixBodyPosition();
    $(window).scrollTop(savedPosition);
}

function closeCreateDepartment() {
    let $recallPopUP = $(".modal-create");
    $recallPopUP.removeClass("show-modal");
    unFixBodyPosition();
    $(window).scrollTop(savedPosition);
}