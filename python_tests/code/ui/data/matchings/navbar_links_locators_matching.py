from ui.data.enums.navbar_links_names import NavbarLinksNames
from ui.locators.main_page_locators import MainPageLocators

NavbarLinksLocatorsMatching = {
    NavbarLinksNames.HOME: MainPageLocators.NavbarLinksLocators.HOME_LINK,
    NavbarLinksNames.TOURNAMENTS: MainPageLocators.NavbarLinksLocators.TOURNAMENTS_LINK,
    NavbarLinksNames.ORGANIZE: MainPageLocators.NavbarLinksLocators.ORGANIZE_LINK,
    NavbarLinksNames.SIGN_IN: MainPageLocators.NavbarLinksLocators.SIGN_IN_LINK,
    NavbarLinksNames.SIGN_UP: MainPageLocators.NavbarLinksLocators.SIGN_UP_LINK,
}
