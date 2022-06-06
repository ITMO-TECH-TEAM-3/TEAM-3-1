import time


class TestUI:
    def test_register(self, register_page):
        time.sleep(3)
        register_page.register("a", "a")


