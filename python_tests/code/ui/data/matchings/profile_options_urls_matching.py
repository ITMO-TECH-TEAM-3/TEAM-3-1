from config.creds import APP_PORT, APP_SERVICE
from ui.data.enums.profile_options_names import ProfileOptionsNames as Names

ProfileOptionsUrlsMatching = {
    f"http://{APP_SERVICE}:{APP_PORT}/profile/top-up": Names.TOP_UP,
    f"http://{APP_SERVICE}:{APP_PORT}/players": Names.PLAYERS_PAGE,
    f"http://{APP_SERVICE}:{APP_PORT}/teams": Names.TEAMS_PAGE,
}
