<#macro login path>
    <form action="${path}" method="post">
        <div><label for="username"> User Name</label>
            <input id="username" type="text" name="username" class="form-control"/>
        </div>
        <br>
        <div><label for="password"> Password</label>
            <input id="password" type="password" name="password" class="form-control"/>
        </div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input id="submit" type="submit" class="btn btn-info" value="Sign in"/></div>
    </form>
</#macro>

<#macro register path>
    <form action="${path}" method="post">
        <label for="username"> User Name </label>
        <input id="username" type="text" name="username" class="form-control
                ${(usernameError??)?string('is-invalid', '')}"
               value="<#if user??>${user.username}</#if>">
        <div class="invalid-feedback">
            <#if usernameError??>
                ${usernameError}
            </#if>
        </div>
        <br>
        <div>
            <label for="password">
                Password
            </label>
            <input id="password" type="password" name="password" class="form-control
                ${(passwordError??)?string('is-invalid', '')}">
            <div class="invalid-feedback">
                <#if passwordError??>
                    ${passwordError}
                </#if>
            </div>
        </div>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input id="submit" type="submit" class="btn btn-success" value="Sign Up"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input class="btn btn-light" type="submit" value="Log Out"/>
    </form>
</#macro>