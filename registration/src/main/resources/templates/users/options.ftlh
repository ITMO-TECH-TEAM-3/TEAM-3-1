<#import "../parts/common.ftlh" as c>

<#assign top_up_path="/profile/top-up">

<@c.page>
    <div class="row">
        <div class="col">
            <div class="card bg-dark text-white">
                <div class="card-header">Replenish the balance</div>
                <div class="card-body">
                    <a href="${top_up_path}" class="btn btn-primary btn-sm"> Select </a>
                </div>
            </div>
        </div>
    </div>
</@c.page>