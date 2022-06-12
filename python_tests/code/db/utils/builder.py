from db.models.models import UserModel, PlayerModel, TeamModel


class MysqlBuilder:
    def __init__(self, client):
        self.client = client

    def add_user(self, username, password):
        user = UserModel(
            username=username,
            password=password,
        )
        self.client.session.add(user)
        self.client.session.commit()

    def add_player(self, name, user_id):
        player = PlayerModel(
            name=name,
            user_id=user_id
        )
        self.client.session.add(player)
        self.client.session.commit()

    def add_team(self, name, creator_id):
        team = TeamModel(
            name=name,
            creator_id=creator_id
        )
        self.client.session.add(team)
        self.client.session.commit()
