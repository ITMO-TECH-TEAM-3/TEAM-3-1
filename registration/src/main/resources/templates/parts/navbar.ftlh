<#include "security.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" style="padding-left: 10px" href="/">
        <div>
            <span style="color:deepskyblue">Ke</span><span style="color:deeppink">KISS</span>
        </div>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Tournaments</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/organize">Organize</a>
            </li>
            <#--            <#if isAdmin>-->
            <li class="nav-item">
                <a class="nav-link" href="/login">
                    <div align="right">
                        Sign in
                    </div>
                </a>
            </li>
            <li class="nav-item">
                <div style="text-align:center">
                    <a class="nav-link" href="/register">
                        Sign up
                    </a>
                </div>
            </li>
            <#--            </#if>-->
        </ul>

        <#--        <div class="navbar-text mr-3">${name}</div>-->
        <#--        <@l.logout />-->
    </div>
</nav>