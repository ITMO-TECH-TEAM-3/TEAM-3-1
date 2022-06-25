<#import "../parts/common.ftlh" as c>

<#assign top_up_path="/profile/top-up">
<#assign players_path="/players">
<#assign teams_path="/teams">

<#--    to do with <#list> -->
<div id="profile"/>
<@c.page>
    <div class="details" style="display: flex">
        <h3 class="name mini-badge-item">
            <span class="text">DoKep</span>
        </h3>
        <h4 style="margin-left: 1000px">
            Balance: ${balance}$
        </h4>
    </div>
    <hr class="rounded"><br>
    <h3>Top scores</h3>
    <div class="container mt-5" id="places">
        <div class="place-card">
            <div class="place">
                <img src="../../static/files/gold-cup.png" style="width: 50px; height: 50px">
                <p id="place_number">
                    1ST
                </p>
            </div>
            <div class="counter">
                <p>
                    0
                </p>
            </div>
        </div>
        <div class="place-card">
            <div class="place">
                <img src="../../static/files/silver-cup.png" style="width: 50px; height: 50px">
                <p id="place_number">
                    2ND
                </p>
            </div>
            <div class="counter">
                <p>
                    0
                </p>
            </div>
        </div>
        <div class="place-card">
            <div class="place">
                <img src="../../static/files/bronze-cup.png" style="width: 50px; height: 50px">
                <p id="place_number">
                    3RD
                </p>
            </div>
            <div class="counter">
                <p>
                    0
                </p>
            </div>
        </div>

    </div><br><br>
    <div class="row mb-5">
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