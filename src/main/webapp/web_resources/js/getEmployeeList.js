function showEmployees(departmentId){
    var host = window.location.hostname;
    var port = window.location.port;
    $(location).attr("href", `http://${host}:${port}/workers?depId=${departmentId}`);
}