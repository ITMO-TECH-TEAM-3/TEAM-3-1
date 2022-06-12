from data_generator import MyFaker
from ui.locators.register_page_locators import RegisterPageLocators
from ui.pages.base_page import BasePage

faker = MyFaker()


class RegisterPage(BasePage):
    def register(self, username, password):
        username_input = self.find(RegisterPageLocators.USERNAME_INPUT).send_keys(username)
        password_input = self.find(RegisterPageLocators.PASSWORD_INPUT).send_keys(password)
        submit_btn = self.find(RegisterPageLocators.SUBMIT_BUTTON).click()

    def fake_invalid_user_data(self,
                               username=None,
                               password=None) -> dict:
        if username is None:
            username = faker.fake_valid_username()
        if password is None:
            password = faker.fake_valid_name()

        return {
            "username": username,
            "password": password,
        }
