from ui.data.enums.navbar_links_names import NavbarLinksNames
from ui.data.matchings.navbar_links_locators_matching import NavbarLinksLocatorsMatching
from ui.data.matchings.navbar_links_urls_matching import NavbarLinksUrlsMatching
from ui.locators.main_page_locators import MainPageLocators
from ui.pages.base_page import BasePage


class MainPage(BasePage):
    def logout(self):
        self.find(MainPageLocators.NavbarLinksLocators.DROPDOWN_MENU_BUTTON).click()
        self.find(MainPageLocators.NavbarLinksLocators.LOGOUT_BUTTON).click()

    def go_navbar_link(self, link_name: NavbarLinksNames):
        self.find(NavbarLinksLocatorsMatching.get(link_name)).click()
        self.browser.switch_to.window(self.browser.window_handles[-1])

    def navbar_link_transition_is_correct(self, page_name: NavbarLinksNames):
        link = self.browser.current_url
        assert (link, page_name) in NavbarLinksUrlsMatching.items(), f"{link} {page_name}"

    def go_to_profile(self):
        self.find(MainPageLocators.NavbarLinksLocators.DROPDOWN_MENU_BUTTON).click()
        self.find(MainPageLocators.NavbarLinksLocators.PROFILE_BUTTON).click()
