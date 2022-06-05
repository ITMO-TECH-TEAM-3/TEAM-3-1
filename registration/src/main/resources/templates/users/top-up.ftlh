<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign form_path="/profile/top-up">

<@c.page>
    <form action="${form_path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <#--            checks for lower than zero-->
            <label for="amount">Replenishment amount ($)</label>
            <input name="amount" class="form-control" id="amount" placeholder="100">
            <input type="hidden" name="userId" value="${userId}">
        </div>
        <input class="btn btn-primary" type="submit" value="Submit" style="margin-top:5px">
    </form>
</@c.page>