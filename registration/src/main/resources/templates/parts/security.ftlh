<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    userId = user.getId()
    isAuthorized = user.isAuthorized()
    >
<#else>
    <#assign
    name = ""
    isAuthorized = false
    userId = 0
    >
</#if>