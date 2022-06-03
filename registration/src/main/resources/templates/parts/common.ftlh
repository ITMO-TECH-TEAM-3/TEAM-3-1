<#macro page>
    <!DOCTYPE html>
    <html lang="eu">
    <head>
        <meta charset="UTF-8">
        <title>Kekiss.com</title>
        <link rel="stylesheet" href="../../static/css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
    </head>
    <body>
    <#include "navbar.ftlh">
    <link rel="stylesheet" href="../../static/css/style.css">
    <img class="image" src="https://assets.challonge.com/assets/community_default_banners/default-cover-3-4f62f5489d5919ce570449a9514ee1bb47f0f836db8201422aeedb85153c17cb.svg"
    style="width: 100%">
    <div class="container mt-5">
        <#nested>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>