<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<@c.page>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Team name</th>
            <th scope="col">Creator</th>
        </tr>
        </thead>
        <tbody>
        <#list teams as team>
            <tr>
                <th scope="row">${team?counter}</th>
                <td>${team.name}</td>
                <td>${creators[team?index].name}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>