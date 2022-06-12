from ui.data.enums.profile_options_names import ProfileOptionsNames
from ui.data.matchings.profile_options_locators_matching import ProfileOptionsLocatorsMatching
from ui.data.matchings.profile_options_urls_matching import ProfileOptionsUrlsMatching
from ui.locators.profile_options_pages_locators import TopUpPageLocators, PlayersPageLocators
from ui.pages.base_page import BasePage


class ProfilePage(BasePage):
    def top_up_balance(self, amount):
        self.go_to_profile_options(ProfileOptionsNames.TOP_UP)
        self.find(TopUpPageLocators.AMOUNT_INPUT).send_keys(amount)
        self.find(TopUpPageLocators.SUBMIT_BUTTON).click()

    def create_player(self, name):
        self.go_to_profile_options(ProfileOptionsNames.PLAYERS_PAGE)
        self.find(PlayersPageLocators.CREATE_PLAYER_BUTTON).click()
        self.find(PlayersPageLocators.PLAYER_NAME_INPUT).send_keys(name)
        self.find(PlayersPageLocators.SUBMIT_BUTTON).click()

    def create_team(self, name):
        self.go_to_profile_options(ProfileOptionsNames.PLAYERS_PAGE)
        self.find(PlayersPageLocators.CREATE_TEAM_BUTTON).click()
        self.find(PlayersPageLocators.PLAYER_NAME_INPUT).send_keys(name)
        self.find(PlayersPageLocators.SUBMIT_BUTTON).click()

    def go_to_profile_options(self, profile_option: ProfileOptionsNames):
        self.find(ProfileOptionsLocatorsMatching.get(profile_option)).click()
        self.browser.switch_to.window(self.browser.window_handles[-1])

    def profile_link_transition_is_correct(self, profile_option: ProfileOptionsNames):
        link = self.browser.current_url
        assert (link, profile_option) in ProfileOptionsUrlsMatching.items(), f"{link} {profile_option}"
