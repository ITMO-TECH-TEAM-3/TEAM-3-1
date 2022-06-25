<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign form_path="/players/join-team">

<@c.page>
    <form action="${form_path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <select class="form-select" aria-label="Default select example" name="playerId">
                <#list players as p>
                    <option value="${p.id}">${p.name}</option>
                </#list>
            </select>
            <br>
            <select class="form-select" aria-label="Default select example" name="teamId">
                <#list teams as t>
                    <option value="${t.id}">${t.name}</option>
                </#list>
            </select>
        </div>
        <input class="btn btn-primary" type="submit" value="Submit" style="margin-top:5px">
    </form>
</@c.page>