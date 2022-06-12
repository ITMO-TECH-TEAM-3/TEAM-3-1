<#import "../parts/common.ftlh" as c>

<#assign top_up_path="/profile/top-up">
<#assign players_path="/players">
<#assign teams_path="/teams">

<#--    to do with <#list> -->
<@c.page>
    <div class="row">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Replenish the balance</div>
                <div class="card-body">
                    <a id="top_up" href="${top_up_path}" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Players page</div>
                <div class="card-body">
                    <a id="players_page" href="${players_path}" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Teams page</div>
                <div class="card-body">
                    <a id="teams_page" href="${teams_path}" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
    </div>
</@c.page>