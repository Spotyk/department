<script src='${pageContext.request.contextPath}/web_resources/js/sign.js'></script>
<div id="login">
    <h1>Welcome Back!</h1>
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <div class="field-wrap">
                <label for="loginEmail">
                Email Address
                </label>
                <input type="text" name="loginEmail" id="loginEmail">
            </div>

            <div class="field-wrap">
                <label for="loginPassword">
                Password
                </label>
                <input type="password" name="loginPassword" id="loginPassword"/>
            </div>
            <button type="submit" class="button button-block">Log In</button>
        </form>
</div>