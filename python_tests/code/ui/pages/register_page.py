import logging

from ui.locators.register_page_locators import RegisterPageLocators
from ui.pages.base_page import BasePage


class RegisterPage(BasePage):
    def register(self, username, password):
        username_input = self.find(RegisterPageLocators.USERNAME_INPUT).send_keys(username)
        password_input = self.find(RegisterPageLocators.PASSWORD_INPUT).send_keys(password)
        submit_btn = self.find(RegisterPageLocators.SUBMIT_BUTTON).click()