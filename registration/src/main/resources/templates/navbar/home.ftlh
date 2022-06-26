<#import "../parts/tournaments_common.ftlh" as c>
<#import "../parts/login.ftlh" as l>
<#import "../parts/success_alert.ftlh" as s>
<@c.page>
    <div>
        <#if alert??>
            <@s.success_alert "Your account was created successfully!"/>
        </#if>
    </div>
    <div class="tournament-container">
        <div class="tournament-btn" style="margin-left: 50px">
            <h2 class="page-heading">Commence battle</h2>
            <p class="lead">Create and manage your tournament, brackets, participants, and more.</p>
            <a class="btn btn-primary" data-turbolinks="false" id="create_tournament" href="tournaments/new">Create tournament</a>
        </div>
        <img class="trophy-img" src="../../static/files/trophy.jpg">
    </div>
</@c.page>