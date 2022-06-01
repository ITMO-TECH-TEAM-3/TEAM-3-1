<#macro login path>
    <form action= "${path}" method="post">
        <div><label> User Name : <input type="text" name="username" required class="form-control" /> </label></div><br>
        <div><label> Password: <input type="password" name="password" required class="form-control" /> </label></div><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" class="btn btn-info" value="Sign in"/></div>
    </form>
</#macro>

<#macro register path>
    <form action= "${path}" method="post">
        <div><label> User Name : <input type="text" name="username" required class="form-control" /> </label></div><br>
        <div><label> Password: <input type="password" name="password" required class="form-control" /> </label></div><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" class="btn btn-success" value="Sign Up"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Log Out"/>
    </form>
</#macro>