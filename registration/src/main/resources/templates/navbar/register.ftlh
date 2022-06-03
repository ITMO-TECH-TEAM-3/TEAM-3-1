<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>
<@c.page>
    <@l.register "/register"/>
    ${message!}
</@c.page>