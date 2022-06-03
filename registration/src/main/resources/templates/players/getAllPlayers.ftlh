<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<@c.page>
    <#list players as p>
        ${p} <br>
    </#list>
</@c.page>