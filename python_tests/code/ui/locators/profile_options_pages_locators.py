from selenium.webdriver.common.by import By


class TopUpPageLocators:
    AMOUNT_INPUT = (By.CSS_SELECTOR, "#amount")
    SUBMIT_BUTTON = (By.CSS_SELECTOR, ".btn-primary")


class PlayersPageLocators:
    CREATE_PLAYER_BUTTON = (By.CSS_SELECTOR, "#create_player")
    CREATE_TEAM_BUTTON = (By.CSS_SELECTOR, "#create_team")
    GET_ALL_PLAYERS_BUTTON = (By.CSS_SELECTOR, "#get_all_players")
    PLAYER_NAME_INPUT = (By.CSS_SELECTOR, "#name")
    SUBMIT_BUTTON = (By.CSS_SELECTOR, ".btn-primary")
    TEAM_NAME_INPUT = (By.CSS_SELECTOR, "#name")

class TeamsPageLocators:
    pass
