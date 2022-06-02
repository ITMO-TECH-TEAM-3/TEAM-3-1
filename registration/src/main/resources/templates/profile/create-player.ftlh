<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">
<@c.page>
    <form action="/profile/create-player" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <label for="name">Player name</label>
            <input name="name" class="form-control" id="name" placeholder="aboba">
            <input type="hidden" name="userId" value="${userId}">
        </div>
        <input class="btn btn-primary" type="submit" value="Submit" style="margin-top:5px">
    </form>
</@c.page>