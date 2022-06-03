<#include "security.ftlh">
<#import "../parts/login.ftlh" as l>
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

    <div class="collapse navbar-collapse" style="display: flex" id="navbarSupportedContent">
        <div>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Tournaments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Organize</a>
                </li>
            </ul>
        </div>
        <div style="margin-left: auto; padding-right: 20px; display: flex; flex-direction: row">
        <#if !isAuthorized>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/login">
                        <div id="sign_in">
                            Sign in
                        </div>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">
                        <div id="sign_up">
                            Sign up
                        </div>
                    </a>
                </li>
                <#else>
                    <@l.logout />
                </#if>
                <div class="navbar-text mr-3">${name}</div>
            </ul>
        </div>
    </div>
</nav>