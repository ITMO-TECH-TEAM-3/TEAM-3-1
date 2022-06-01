<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>
<#import "../parts/incorrect_data_alert.ftlh" as i>
<@c.page>
    <@l.login "/login"/><br>
    <#if error??>
        <@i.incorrect_alert/>
    </#if>
    <a href="/register">Register</a>
</@c.page>