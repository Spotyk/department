<script src='${pageContext.request.contextPath}/web_resources/js/sign.js'></script>
<div id="login" action="/logout">
    <div class="field-wrap">
        <h1>Hello, ${sessionScope.userName}<h1>
            <div class="field-wrap">
                <img src="/avatar?photoName=${sessionScope.userPhoto}.png" alt="Smiley face" height="200" width="200">
                <input type="hidden" name="photoName" value="${sessionScope.userPhoto}.png">
            </div>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>