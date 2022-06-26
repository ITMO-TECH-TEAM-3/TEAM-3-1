<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign create_player_path="/players/new-player">
<#assign create_team_path="/players/new-team">
<#assign get_all_players_path="/players/all">
<#assign join_team_path="/players/join-team">
<#import "../parts/success_alert.ftlh" as s>

<@c.page>
    <#if create_player_alert??>
        <@s.success_alert create_player_alert/>
    </#if>
    <#if create_team_alert??>
        <@s.success_alert create_team_alert/>
    </#if>
    <#if join_team_alert??>
        <@s.success_alert join_team_alert/>
    </#if>
    <div class="row">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Create player</div>
                <div class="card-body">
                    <a href="${create_player_path}" id="create_player" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Create team</div>
                <div class="card-body">
                    <form action="${create_team_path}" method="get">
                        <input type="hidden" name="userId" value="${userId}">
                        <input id="create_team" class="btn btn-primary btn-sm" type="submit" value="Select">
                    </form>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Join team</div>
                <div class="card-body">
                    <form action="${join_team_path}" method="get">
                        <input type="hidden" name="userId" value="${userId}">
                        <input id="join_team" class="btn btn-primary btn-sm" type="submit" value="Select">
                    </form>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Get all players</div>
                <div class="card-body">
                    <form action="${get_all_players_path}" method="get">
                        <input type="hidden" name="userId" value="${userId}">
                        <input id="get_all_players" class="btn btn-primary btn-sm" type="submit" value="Select">
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>