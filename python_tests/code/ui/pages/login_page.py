from ui.locators.login_page_locators import LoginPageLocators
from ui.pages.base_page import BasePage
from ui.pages.main_page import MainPage


class LoginPage(BasePage):
    def login(self, username, password):
        self.find(LoginPageLocators.USERNAME_INPUT).send_keys(username)
        self.find(LoginPageLocators.PASSWORD_INPUT).send_keys(password)
        self.find(LoginPageLocators.SIGN_IN_BUTTON).click()
        return MainPage(self.browser, self.browser.current_url)