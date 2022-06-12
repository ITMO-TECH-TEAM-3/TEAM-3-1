from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

from db.models.models import UserModel, PlayerModel, TeamModel


class MysqlClient:

    def __init__(self, db_name):
        # self.user = os.environ['MYSQL_USER']
        # self.port = os.environ['MYSQL_PORT']
        # self.password = os.environ['MYSQL_PASSWORD']
        # self.host = os.environ['MYSQL_HOST']
        self.user = "aboba"
        self.port = "5432"
        self.password = "aboba"
        self.host = "postgres"
        self.db_name = db_name

        self.connection = None
        self.engine = None
        self.session = None

    def connect(self, db_created=True):
        db = self.db_name if db_created else ''
        self.engine = create_engine(f'postgresql+psycopg2://{self.user}:{self.password}@{self.host}/{db}')
        self.connection = self.engine.connect()
        session = sessionmaker(bind=self.connection.engine)
        self.session = session()

    def execute_query(self, query, fetch=False):
        res = self.connection.execute(query)
        if fetch:
            return res.fetchall()

    def get_users(self, **filters):
        self.session.commit()
        res = self.session.query(UserModel).filter_by(**filters)
        return res.all()

    def get_users_by_username(self, username):
        return self.get_users(**{"username": username})

    def get_current_user(self):
        return self.get_users(**{"active": 1})

    def user_was_created_with_correspondent_data(self, username, data):
        user = self.get_users_by_username(username)[0]
        return user.username == data['username'][:255]  # and user.balance == 0.00 and user.active is True

    def get_players(self, **filters):
        self.session.commit()
        res = self.session.query(PlayerModel).filter_by(**filters)
        return res.all()

    def get_players_by_name(self, name):
        return self.get_players(**{"name": name})

    def get_teams(self, **filters):
        self.session.commit()
        res = self.session.query(TeamModel).filter_by(**filters)
        return res.all()

    def get_teams_by_name(self, name):
        return self.get_teams(**{"name": name})