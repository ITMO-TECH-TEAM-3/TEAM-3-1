import os

import pytest

from db.client.client import DatabaseClient
from db.utils.builder import DatabaseBuilder


def repo_root():
    return os.path.abspath(os.path.join(__file__, os.path.pardir))


def pytest_configure(config):
    if not hasattr(config, "workerinput") or str(config.workerinput["workerid"]) == "gw0":
        mysql_client = DatabaseClient(db_name='registration')
        mysql_client.connect(db_created=True)
        mysql_client.connection.close()


class Database:
    @pytest.fixture(scope='function', autouse=True)
    def setup(self, mysql_client):
        self.client: DatabaseClient = mysql_client
        self.builder: DatabaseBuilder = DatabaseBuilder(self.client)


@pytest.fixture(scope='session')
def mysql_client() -> DatabaseClient:
    client = DatabaseClient(db_name='registration')
    client.connect()
    yield client
    client.connection.close()
