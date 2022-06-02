<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>
<#import "../parts/success_register_alert.ftlh" as s>
<@c.page>
    <div>
        <#if alert??>
            <@s.success_alert/>
        </#if>
    </div>
</@c.page>