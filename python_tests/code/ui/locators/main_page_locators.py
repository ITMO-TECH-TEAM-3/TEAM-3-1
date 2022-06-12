from selenium.webdriver.common.by import By


class MainPageLocators:
    class NavbarLinksLocators:
        HOME_LINK = (By.CSS_SELECTOR, "#home")
        TOURNAMENTS_LINK = (By.CSS_SELECTOR, "#tournaments")
        ORGANIZE_LINK = (By.CSS_SELECTOR, "#organize")
        SIGN_IN_LINK = (By.CSS_SELECTOR, "#sign_in")
        SIGN_UP_LINK = (By.CSS_SELECTOR, "#sign_up")
        DROPDOWN_MENU_BUTTON = (By.CSS_SELECTOR, "#dropdownMenuButton")
        LOGOUT_BUTTON = (By.CSS_SELECTOR, "#logout")
        PROFILE_BUTTON = (By.CSS_SELECTOR, "#profile")
        SUCCESS_REGISTER_ALERT = (By.CSS_SELECTOR, ".alert-success")
