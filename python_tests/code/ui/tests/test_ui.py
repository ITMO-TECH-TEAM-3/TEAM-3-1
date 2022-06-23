import time

import pytest

from config.creds import APP_PORT, APP_SERVICE
from conftest import Database
from data_generator import MyFaker
from ui.data.enums.navbar_links_names import NavbarLinksNames
from ui.data.enums.profile_options_names import ProfileOptionsNames
from ui.locators.login_page_locators import LoginPageLocators
from ui.locators.main_page_locators import MainPageLocators
from ui.locators.register_page_locators import RegisterPageLocators

faker = MyFaker()


class TestUI(Database):
    @pytest.mark.parametrize("username, password", [("test_username", "test_password")])
    @pytest.mark.nologin
    def test_valid_register(self, register_page, username, password):
        time.sleep(10)
        main_page = register_page.register(username, password)
        assert main_page.is_element_present(MainPageLocators.NavbarLinksLocators.SUCCESS_REGISTER_ALERT)
        assert main_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/", \
            f"actual: {main_page.browser.current_url}, expected: http://{APP_SERVICE}:{APP_PORT}/"
        assert self.client.user_was_created_with_correspondent_data(username, {
            "username": username,
            "password": password
        })
        main_page.logout()

    @pytest.mark.nologin
    def test_register_with_existing_username(self, register_page):
        register_page.register("test_username", "test_password")
        assert register_page.is_element_present(RegisterPageLocators.USER_ALREADY_EXISTS_ALERT)

    @pytest.mark.parametrize("username, password", [("test_username", "test_password")])
    @pytest.mark.nologin
    def test_valid_login(self, login_page, username, password):
        main_page = login_page.login(username, password)
        assert login_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/", \
            f"actual: {login_page.browser.current_url}, expected: http://{APP_SERVICE}:{APP_PORT}/"
        main_page.logout()
    # @pytest.mark.parametrize("username, password", [("invalid_username", "invalid_password")])
    # @pytest.mark.nologin
    # def test_invalid_login(self, login_page, username, password):
    #     login_page.login(username, password)
    #     assert login_page.is_element_present(LoginPageLocators.INVALID_DATA_ALERT)
    #
    # @pytest.mark.nologin
    # def test_register_with_empty_data(self, register_page):
    #     register_page.register("", "")
    #     register_page.is_element_present(RegisterPageLocators.EMPTY_USERNAME_ALERT)
    #     register_page.is_element_present(RegisterPageLocators.EMPTY_PASSWORD_ALERT)
    #
    # @pytest.mark.nologin
    # def test_register_with_too_long_data(self, register_page):
    #     data = register_page.fake_invalid_user_data(
    #         username=faker.fake_too_long_name(),
    #         password=faker.fake_too_long_name())
    #     register_page.register(
    #         username=data['username'],
    #         password=data['password']
    #     )
    #     register_page.is_element_present(RegisterPageLocators.TOO_LONG_USERNAME_ALERT)
    #     register_page.is_element_present(RegisterPageLocators.TOO_LONG_PASSWORD_ALERT)
    #
    # def test_logout(self, main_page):
    #     main_page.logout()
    #     assert main_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/login?logout", \
    #         f"actual: {main_page.browser.current_url}, expected: http://{APP_SERVICE}:{APP_PORT}/login?logout"
    #     # todo: check active
    #
    # @pytest.mark.nologin
    # @pytest.mark.parametrize("link_name", [
    #     NavbarLinksNames.HOME,
    #     NavbarLinksNames.SIGN_IN,
    #     NavbarLinksNames.SIGN_UP])
    # def test_go_navbar_link(self, main_page, link_name):
    #     main_page.go_navbar_link(link_name)
    #     main_page.navbar_link_transition_is_correct(link_name)
    #
    # def test_go_to_profile(self, main_page):
    #     main_page.go_to_profile()
    #     assert main_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/profile"
    #
    # @pytest.mark.parametrize("amount", [500])
    # def test_top_up_balance(self, profile_page, amount):
    #     # todo: get_active_user instead if active works
    #     balance_before = self.client.get_users_by_username("test_username")[0].balance
    #     profile_page.top_up_balance(amount)
    #     assert self.client.get_users_by_username("test_username")[0].balance - balance_before == amount
    #
    # @pytest.mark.parametrize("profile_option", [ProfileOptionsNames.TOP_UP,
    #                                             ProfileOptionsNames.PLAYERS_PAGE,
    #                                             ProfileOptionsNames.TEAMS_PAGE])
    # def test_go_to_profile_options(self, profile_page, profile_option):
    #     profile_page.go_to_profile_options(profile_option)
    #     profile_page.profile_link_transition_is_correct(profile_option)
    #
    # @pytest.mark.parametrize("name", ["aboba"])
    # def test_create_player(self, profile_page, name):
    #     profile_page.create_player(name)
    #     assert len(self.client.get_players_by_name(name))
    #
    # @pytest.mark.parametrize("name", ["aboba"])
    # def test_create_team(self, profile_page, name):
    #     profile_page.create_team(name)
    #     assert len(self.client.get_teams_by_name(name))
