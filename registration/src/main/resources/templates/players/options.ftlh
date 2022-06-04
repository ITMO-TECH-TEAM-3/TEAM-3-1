<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign create_player_path="/players/new-player">
<#assign create_team_path="/players/new-team">
<#assign get_all_players_path="/players/all">

<@c.page>
    <div class="row">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Create player</div>
                <div class="card-body">
                    <a href="${create_player_path}" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Create team</div>
                <div class="card-body">
                    <a href="${create_team_path}" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Get all players</div>
                <div class="card-body">
                    <form action="${get_all_players_path}" method="get">
                        <input type="hidden" name="userId" value="${userId}">
                        <input class="btn btn-primary btn-sm" type="submit" value="Select">
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>