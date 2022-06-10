from selenium.webdriver.common.by import By


class RegisterPageLocators:
    USERNAME_INPUT = (By.CSS_SELECTOR, "#username")
    PASSWORD_INPUT = (By.CSS_SELECTOR, "#password")
    SUBMIT_BUTTON = (By.CSS_SELECTOR, "#submit")
    EMPTY_USERNAME_ALERT = (
        By.CSS_SELECTOR,
        "//input[@id='username']/following-sibling::div[1][contains(text(), 'Enter your name')]"
    )
    EMPTY_PASSWORD_ALERT = (
        By.CSS_SELECTOR,
        "//input[@id='password']/following-sibling::div[1][contains(text(), 'Enter password')]"
    )
    TOO_LONG_USERNAME_ALERT = (
        By.CSS_SELECTOR,
        "//input[@id='username']/following-sibling::div[1][contains(text(), 'Name is too long')]"
    )
    TOO_LONG_PASSWORD_ALERT = (
        By.CSS_SELECTOR,
        "//input[@id='password']/following-sibling::div[1][contains(text(), 'Password is too long')]"
    )
    USER_ALREADY_EXISTS_ALERT = (
        By.CSS_SELECTOR, ".alert-danger"
    )
