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

        <#list players>
            <#items as player>
                    <tr>
                        <th scope="row">${player?counter}</th>
                        <td>${player.name}</td>
                        <#if player.teams?? && (player.teams?size != 0)>
                            <#list player.teams as t>
                                <td>aboba</td>
                                <td>${(t.name??)?string('${t.name}', 'None')}</td>
                            </#list>
                        <#else>
                            <td>None</td>
                        </#if>
                    </tr>
            </#items>
        </#list>
        </tbody>
    </table>
</@c.page>