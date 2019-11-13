function createDepartment(){
        let $createPopUP = $(".modal-create");
        $createPopUP.addClass("show-modal");
        savedPosition = $(window).scrollTop();
        fixBodyPosition();
}