<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/parts/libraries.jspf" %>
<html lang="en">

<jsp:include page="/WEB-INF/parts/head.jsp" />

<body>

    <jsp:include page="/WEB-INF/parts/header.jsp" />

    <a class="btn btn-warning create-button" onclick="createDepartment()">Create Department</a>

    <main class="main-container">
        <div class="flex-container">
            <c:forEach items="${list}" var="dep">
                <div class="flex-item dark-gray-color">
                    <div class="flex-inline-container">
                        <div class="flex-inline-item ">
                            ${dep.id}
                        </div>
                        <div class="flex-inline-item ">
                            ${dep.name}
                        </div>
                        <div class="flex-inline-item ">
                            <a class="btn btn-primary edit" onclick="editDepartment(${dep.id}, '${dep.name}')">edit</a>
                        </div>
                        <div class="flex-inline-item ">
                            <a class="btn btn-primary" onclick="deleteDepartment(${dep.id})">delete</a>
                        </div>
                        <div class="flex-inline-item ">
                            <a class="btn btn-primary" onclick="showEmployees(${dep.id})">employees</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        </div>
    </main>

    <jsp:include page="/WEB-INF/parts/footer.jsp" />

    <div id="popupEdit" class="modal-edit">
        <div class="modal-edit-content">
            <a class="close-button"><img src="${pageContext.request.contextPath}/web_resources/img/close.png" onclick="closeEditDepartment()"></a>
            <form action="/updateDepartment" method="POST">
                <div class="input-group mb-3">
                    <span for="name" class="nameLabel not-correct-input no-display duplicateName"> Name is exists.</span>
                    <span for="name" class="nameLabel not-correct-input no-display notValidName"> Name is not valid.</span>
                    <div class="full-width">
                        <input name="name" id="name" type="text" class="form-control" placeholder="Department Name" maxlength="50" required>
                        <input type="hidden" name="hiddenDepId" id="hiddenDepId" value="">
                    </div>
                </div>
                <a class="submit-button" onclick="sendRequest()">Submit</a>
            </form>
        </div>
    </div>


    <div id="popupCreate" class="modal-create">
        <div class="modal-edit-content">
            <a class="close-button"><img src="${pageContext.request.contextPath}/web_resources/img/close.png" onclick="closeCreateDepartment()"></a>
            <form action="/createDepartment" method="POST">
                <div class="input-group mb-3">
                    <span for="newName" class="nameLabel not-correct-input no-display duplicateName"> Name is exists.</span>
                    <span for="newName" class="nameLabel not-correct-input no-display notValidName"> Name is not valid.</span>
                    <div class="full-width">
                        <input name="newName" id="newName" type="text" class="form-control" placeholder="Department Name" maxlength="50" required>
                    </div>
                </div>
                <a class="submit-button" onclick="sendCreateRequest()">Submit</a>
            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/web_resources/js/popap.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/editDepartment.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/request.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/getEmployeeList.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/delete.js"></script>

</body>

</html>