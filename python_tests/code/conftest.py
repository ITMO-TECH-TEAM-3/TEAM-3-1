import os

import pytest

from db.client.client import MysqlClient
from db.utils.builder import MysqlBuilder


def repo_root():
    return os.path.abspath(os.path.join(__file__, os.path.pardir))


def pytest_configure(config):
    if not hasattr(config, "workerinput") or str(config.workerinput["workerid"]) == "gw0":
        mysql_client = MysqlClient(db_name='registration')
        mysql_client.connect(db_created=True)
        mysql_client.connection.close()


class MySql:
    @pytest.fixture(scope='function', autouse=True)
    def setup(self, mysql_client):
        self.client: MysqlClient = mysql_client
        self.builder: MysqlBuilder = MysqlBuilder(self.client)


@pytest.fixture(scope='session')
def mysql_client() -> MysqlClient:
    client = MysqlClient(db_name='registration')
    client.connect()
    yield client
    client.connection.close()
