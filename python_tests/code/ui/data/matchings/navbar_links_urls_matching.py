from config.creds import APP_PORT, APP_SERVICE
from ui.data.enums.navbar_links_names import NavbarLinksNames as Names

NavbarLinksUrlsMatching = {
    f"http://{APP_SERVICE}:{APP_PORT}/": Names.HOME,
    f"http://{APP_SERVICE}:{APP_PORT}/login": Names.SIGN_IN,
    f"http://{APP_SERVICE}:{APP_PORT}/register": Names.SIGN_UP,
}
