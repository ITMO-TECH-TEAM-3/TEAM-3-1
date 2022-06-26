<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<@c.page>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Team name</th>
        </tr>
        </thead>
        <tbody>
        <#assign i = 1>
        <#list players>
            <#items as player>
                <#if !player.teams?? || player.teams?size == 0>
                    <tr>
                        <th scope="row">${i}</th>
                        <td>${player.name}</td>
                        <td>None</td>
                        <#assign i++>
                        <#continue>
                    </tr>
                </#if>
                <#list player.teams>
                    <#items as t>
                        <tr>
                            <th scope="row">${i}</th>
                            <td>${player.name}</td>
                            <#if (player.teams?size != 0)>
                                <td>${(t.name??)?string('${t.name}', 'None')}</td>
                            <#else>
                                <td>None</td>
                            </#if>
                            <#assign i++>
                        </tr>
                    </#items>
                </#list>
            </#items>
        </#list>
        </tbody>
    </table>
</@c.page>