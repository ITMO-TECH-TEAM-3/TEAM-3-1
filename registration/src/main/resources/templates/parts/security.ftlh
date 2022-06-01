<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAuthorized = user.isAuthorized()
    >
<#else>
    <#assign
    name = ""
    isAuthorized = false
    >
</#if>