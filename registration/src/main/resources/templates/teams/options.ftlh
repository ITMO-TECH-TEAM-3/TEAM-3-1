<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#assign get_all_teams_path="/teams/all">

<@c.page>
    <div class="row">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Get all teams</div>
                <div class="card-body">
                    <form action="${get_all_teams_path}" method="get">
                        <input id="get_all_teams_path" class="btn btn-primary btn-sm" type="submit" value="Select">
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>