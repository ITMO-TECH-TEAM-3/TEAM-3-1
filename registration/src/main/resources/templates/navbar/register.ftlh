<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>
<#import "../parts/incorrect_data_alert.ftlh" as i>
<@c.page>
    <@l.register "/register"/>
    <br>
    <#if message??>
        <@i.incorrect_alert "User already exists"/>
    </#if>
</@c.page>