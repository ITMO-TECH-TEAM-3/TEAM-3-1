<#import "../parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Create new player</div>
                <div class="card-body">
                    <a href="/profile/create-player" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Make a bet</div>
                <div class="card-body">
                    <a href="/profile/make-bet" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Replenish the balance</div>
                <div class="card-body">
                    <a href="/profile/top-up" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
    </div>
</@c.page>