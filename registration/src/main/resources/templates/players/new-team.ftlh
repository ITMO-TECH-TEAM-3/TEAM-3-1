<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign form_path="/players/new-team">
<#--    todo: need to pass player here   -->

<@c.page>
    <form action="${form_path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <label for="name">Team name</label>
            <input name="name" class="form-control" id="name" placeholder="aboba team">
            <select class="form-select" aria-label="Default select example" name="creatorId">
                <#list players as p>
                    <option value="${p.id}">${p.name}</option>
                </#list>
            </select>
        </div>
        <input class="btn btn-primary" type="submit" value="Submit" style="margin-top:5px">
    </form>
</@c.page>