var host = window.location.hostname;
var port = window.location.port;

function deleteDepartment(id) {
    $.ajax({
        url: '/deleteDepartment',
        type: 'post',
        data: { id: id }
    }).statusCode({
        200: function() { window.location.replace(`http://${host}:${port}/departments`); }
    });
}

function deleteWorker(id, depId) {
    $.ajax({
        url: '/deleteWorker',
        type: 'post',
        data: { id: id }
    }).statusCode({
        200: function() { window.location.replace(`http://${host}:${port}/workers?depId=${depId}`); }
    });
}