<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/parts/libraries.jspf"%>
<html lang="en">
<jsp:include page="/WEB-INF/parts/head.jsp" />

<body>

    <jsp:include page="/WEB-INF/parts/header.jsp" />

    <a class="btn btn-warning create-button" onclick="createWorker()">Create Worker</a>
    <input type="hidden" id="depId" name="depId" value="${depId}" />

    <main class="main-container">
        <div class="flex-container">
            <c:forEach items="${list}" var="worker">
                <div class="flex-item dark-gray-color">
                    <div class="flex-inline-container">
                        <div class="flex-inline-item ">
                            ${worker.id}
                        </div>
                        <div class="flex-inline-item ">
                            ${worker.name}
                        </div>
                        <div class="flex-inline-item ">
                            ${worker.salary}
                        </div>
                        <div class="flex-inline-item ">
                            ${worker.date}
                        </div>
                        <div class="flex-inline-item ">
                            ${worker.email}
                        </div>
                        <div class="flex-inline-item ">
                            <a class="btn btn-primary edit" onclick="editWorker(${worker.id}, ${worker.salary}, '${worker.name}', '${worker.email}', '${worker.date}')">edit</a>
                        </div>
                        <div class="flex-inline-item ">
                            <a class="btn btn-primary" onclick="deleteWorker(${worker.id},${depId})">delete</a>
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
            <form action="/" method="GET">
                <div class="input-group mb-3">
                    <span for="newName" class="nameLabel not-correct-input no-display notValidName">Not correct name.</span>
                    <div class="full-width">
                        Name
                        <input name="editName" id="editName" type="text" class="form-control" placeholder="Worker Name" maxlength="50" required>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <span for="createEmail" class="nameLabel not-correct-input no-display notValidNumber">Not correct salary.</span>
                    <div class="full-width">
                        Salary
                        <input name="editSalary" id="editSalary" type="number" class="form-control" placeholder="Salary" min="1" max="99999" required>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <span for="createEmail" class="nameLabel not-correct-input no-display notValidEmail">Not correct email.</span>
                    <span for="createEmail" class="nameLabel not-correct-input no-display duplicateEmail">Duplicate email.</span>
                    <div class="full-width">
                        Email
                        <input name="editEmail" id="editEmail" type="email" class="form-control" placeholder="Email" maxlength="50" required>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <span for="createEmail" class="nameLabel not-correct-input no-display notValidDate">Not correct date.</span>
                    <div class="full-width">
                        Date
                        <input name="editDate" id="editDate" type="date" class="form-control" placeholder="Date" maxlength="50" required>
                    </div>
                </div>
                <input type="hidden" id="hiddenworkerId" value="" />
                <input type="hidden" id="hiddenWorkerOldEmail" value="" />
                <a class="submit-button" onclick="sendUpdateWorkerRequest()">Submit</a>
            </form>
        </div>
    </div>


    <div id="popupCreate" class="modal-create">
        <div class="modal-edit-content">
            <a class="close-button"><img src="${pageContext.request.contextPath}/web_resources/img/close.png" onclick="closeCreateDepartment()"></a>
            <form action="/" method="GET">
                <div class="input-group mb-3">
                    <span for="newName" class="nameLabel not-correct-input no-display notValidName">Not correct name.</span>
                    <div class="full-width">
                        <input name="createName" id="createName" type="text" class="form-control" placeholder="Worker Name" maxlength="50" required>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <span for="createEmail" class="nameLabel not-correct-input no-display notValidNumber">Not correct salary.</span>


                    <div class="full-width">
                        <input name="createSalary" id="createSalary" type="number" class="form-control" placeholder="Salary" min="0" max="99999" required>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <span for="createEmail" class="nameLabel not-correct-input no-display notValidEmail">Not correct email.</span>
                    <span for="createEmail" class="nameLabel not-correct-input no-display duplicateEmail">Duplicate email.</span>

                    <span for="createEmail" class="nameLabel correct-input no-display">Success</span>

                    <div class="full-width">
                        <input name="createEmail" id="createEmail" type="email" class="form-control" placeholder="Email" maxlength="50" required>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <span for="createEmail" class="nameLabel not-correct-input no-display notValidDate">Not correct date.</span>

                    <span for="createDate" class="nameLabel correct-input no-display">Success</span>
                    <div class="full-width">
                        <input name="createDate" id="createDate" type="date" class="form-control" placeholder="Date" maxlength="50" required>
                    </div>
                </div>
                <a class="submit-button" onclick="sendCreateWorkerRequest()">Submit</a>
            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/web_resources/js/editDepartment.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/request.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/delete.js"></script>
    <script src="${pageContext.request.contextPath}/web_resources/js/popap.js"></script>

</body>

</html>