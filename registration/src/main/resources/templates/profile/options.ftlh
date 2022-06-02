<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">
<@c.page>
    <div class="card">
        <div class="card-header">Create new player</div>
        <div class="card-body">
            <a href="/profile/${userId}/create-team" class="btn btn-primary btn-sm"> Select </a>
        </div>
    </div>
    <div class="card">
        <div class="card-header">Create new team</div>
        <div class="card-body">
            <a href="/profile/${userId}/create-team" class="btn btn-primary btn-sm"> Select </a>
        </div>
    </div>
    <div class="card">
        <div class="card-header">Make a bet</div>
        <div class="card-body">
            <a href="/profile/${userId}" class="btn btn-primary btn-sm"> Select </a>
        </div>
    </div>
</@c.page>