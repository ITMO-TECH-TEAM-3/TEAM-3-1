<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign create_player_path="/players/new-player">
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
                <div class="card-header">Get all players</div>
                <div class="card-body">
                    <form action="${get_all_players_path}" method="get">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="hidden" name="userId" value="${userId}">
                        <a href="${get_all_players_path}" class="btn btn-primary btn-sm"> Select </a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>