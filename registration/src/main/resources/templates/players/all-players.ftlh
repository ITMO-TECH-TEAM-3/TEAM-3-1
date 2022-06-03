<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<@c.page>
    <#list players as p>
        ${p}
        <ul>
            <#list p.teams as t>
                <li>${t}</li>
            </#list>
        </ul>
    </#list>
</@c.page>