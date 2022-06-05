import pdb

import requests

# from data_generator import MyFaker


class ApiClient:
    def __init__(self, base_url, login, password):
        self.base_url = base_url
        self.login = login
        self.password = password
        self.session = requests.Session()

    # def fake_invalid_user_data(self,
    #                            name=MyFaker.fake_valid_name(),
    #                            surname=MyFaker.fake_valid_name(),
    #                            middle_name=MyFaker.fake_valid_name(),
    #                            username=MyFaker.fake_valid_username(),
    #                            password=MyFaker.fake_valid_name(),
    #                            email=MyFaker.fake_valid_email()) -> dict:
    #     return {
    #         "name": name,
    #         "surname": surname,
    #         "middle_name": middle_name,
    #         "username": username,
    #         "password": password,
    #         "email": email,
    #     }

    def add_user(self, data):
        url = "http://127.0.0.1:8080/register"
        headers = {
            "Referer": "http://127.0.0.1:8080/register"
        }
        body = {
            # "name": data['name'],
            # "surname": data['surname'],
            # "middle_name": data['middle_name'],
            "username": data['username'],
            "password": data['password'],
            "_csrf": "c55533a8-ef6c-472b-afec-4a33beb3047d"
            # "email": data['email'],
        }
        res = self._request("GET", location=url, headers=headers, json=body)
        pdb.set_trace()
        return res
    def go_to_login_page(self):
        url = "http://127.0.0.1:8080/login"
        res = self._request("GET", url)
        pdb.set_trace()

    def go_to_profile_page(self):
        url = "http://127.0.0.1:8080/profile"
        res = self._request("GET", url)
        pdb.set_trace()

    def mylogin(self):
        url = "http://127.0.0.1:8080/login"
        headers = {
            "Content-Type": "application/x-www-form-urlencoded"
        }
        body = {
            "usernazxcme": "DoKepDoKep",
            "password": "DoKepDoKep",
        }
        res = self.session.request("POST", url=url, headers=headers, data=body)
        # res = self._request("POST", location=url, headers=headers, data=body)
        assert res.url == "http://app:8080/login?error"

    def go_somewhere(self):
        url = "http://127.0.0.1:8080"
        # res = self._request("GET", url)
        res = self.session.request("GET", url=url)
        pdb.set_trace()

    def change_password(self, username, password):
        url = f'http://app:8089/api/user/{username}/change-password'
        data = {
            "password": password
        }
        res = self._request("PUT", location=url, json=data)
        return res

    def block_user(self, username):
        url = f'http://app:8089/api/user/{username}/block'
        res = self._request("POST", location=url)
        return res

    def accept_user(self, username):
        url = f'http://app:8089/api/user/{username}/accept'
        res = self._request("POST", location=url)
        return res

    def delete_user(self, username):
        url = f"http://app:8089/api/user/{username}"
        res = self._request("DELETE", location=url)
        return res

    def get_status(self):
        url = 'http://app:8089/status'
        res = self._request("GET", location=url)
        return res

    def _request(self, method, location, headers=None, data=None, params=None, json=None):
        url = location
        response = self.session.request(method=method, url=url, headers=headers, data=data, params=params, json=json)
        return response

    def invalid_login(self, username, password):
        url = 'http://app:8089/login'
        data = {
            "username": username,
            "password": password
        }
        headers = {
            'Referer': 'http://app:8089/login'
        }

        result = self._request('POST', url, headers=headers, data=data)
        return result

    def post_login(self):
        url = 'http://app:8089/login'
        data = {
            "username": self.login,
            "password": self.password
        }
        headers = {
            'Referer': 'http://app:8089/login'
        }

        result = self._request('POST', url, headers=headers, data=data)
        return result