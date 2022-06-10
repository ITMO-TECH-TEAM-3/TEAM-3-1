from selenium.webdriver.common.by import By


class LoginPageLocators:
    USERNAME_INPUT = (By.CSS_SELECTOR, "#username")
    PASSWORD_INPUT = (By.CSS_SELECTOR, "#password")
    SIGN_IN_BUTTON = (By.CSS_SELECTOR, "#submit")
    INVALID_DATA_ALERT = (By.CSS_SELECTOR, ".alert-danger")
