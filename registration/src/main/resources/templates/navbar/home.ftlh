<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>
<#import "../parts/success_alert.ftlh" as s>
<@c.page>
    <div>
        <#if alert??>
            <@s.success_alert "Your account was created successfully!"/>
        </#if>
    </div>
</@c.page>