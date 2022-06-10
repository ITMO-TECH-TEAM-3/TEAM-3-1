import time

import pytest

from config.creds import APP_PORT, APP_SERVICE
from data_generator import MyFaker
from ui.data.enums.navbar_links_names import NavbarLinksNames
from ui.locators.login_page_locators import LoginPageLocators
from ui.locators.register_page_locators import RegisterPageLocators

faker = MyFaker()


class TestUI:
    @pytest.mark.parametrize("username, password", [("test_username", "test_password")])
    @pytest.mark.nologin
    def test_valid_register(self, register_page, username, password):
        time.sleep(10)
        register_page.register(username, password)
        assert register_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/", \
            f"actual: {register_page.browser.current_url}, expected: http://{APP_SERVICE}:{APP_PORT}/"
    
    @pytest.mark.nologin
    def test_register_with_existing_username(self, register_page):
        register_page.register("test_username", "test_password")
        assert register_page.is_element_present(RegisterPageLocators.USER_ALREADY_EXISTS_ALERT)

    @pytest.mark.parametrize("username, password", [("test_username", "test_password")])
    @pytest.mark.nologin
    def test_valid_login(self, login_page, username, password):
        login_page.login(username, password)
        assert login_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/", \
            f"actual: {login_page.browser.current_url}, expected: http://{APP_SERVICE}:{APP_PORT}/"

    @pytest.mark.parametrize("username, password", [("invalid_username", "invalid_password")])
    @pytest.mark.nologin
    def test_invalid_login(self, login_page, username, password):
        login_page.login(username, password)
        assert login_page.is_element_present(LoginPageLocators.INVALID_DATA_ALERT)

    @pytest.mark.nologin
    def test_register_with_empty_data(self, register_page):
        register_page.register("", "")
        register_page.is_element_present(RegisterPageLocators.EMPTY_USERNAME_ALERT)
        register_page.is_element_present(RegisterPageLocators.EMPTY_PASSWORD_ALERT)

    @pytest.mark.nologin
    def test_register_with_too_long_data(self, register_page):
        data = register_page.fake_invalid_user_data(
            username=faker.fake_too_long_name(),
            password=faker.fake_too_long_name())
        register_page.register(
            username=data['username'],
            password=data['password']
        )
        register_page.is_element_present(RegisterPageLocators.TOO_LONG_USERNAME_ALERT)
        register_page.is_element_present(RegisterPageLocators.TOO_LONG_PASSWORD_ALERT)

    def test_logout(self, main_page):
        main_page.logout()
        assert main_page.browser.current_url == f"http://{APP_SERVICE}:{APP_PORT}/login?logout", \
            f"actual: {main_page.browser.current_url}, expected: http://{APP_SERVICE}:{APP_PORT}/login?logout"

    @pytest.mark.parametrize("link_name", [
        NavbarLinksNames.HOME,
        NavbarLinksNames.SIGN_IN,
        NavbarLinksNames.SIGN_UP])
    def test_go_navbar_link(self, main_page, link_name):
        main_page.go_navbar_link(link_name)
        main_page.navbar_link_transition_is_correct(link_name)
