function createWorker() {
    let $recallPopUP = $(".modal-create");
    $recallPopUP.addClass("show-modal");
    savedPosition = $(window).scrollTop();
    fixBodyPosition();
}

function editWorker(id, salary, name, email, date) {
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
    let $createPopUP = $(".modal-create");
    $createPopUP.addClass("show-modal");
    savedPosition = $(window).scrollTop();
    fixBodyPosition();
}