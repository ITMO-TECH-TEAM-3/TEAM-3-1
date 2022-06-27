from sqlalchemy import Column, String, Boolean, Numeric, Integer
from sqlalchemy.dialects.postgresql import UUID
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()


class UserModel(Base):
    __tablename__ = 'users'

    id = Column(UUID(as_uuid=True), primary_key=True, nullable=False)
    username = Column(String(255), unique=True, nullable=False)
    password = Column(String(255), nullable=False)
    active = Column(Boolean, default=False)
    balance = Column(Numeric, default=0)


class PlayerModel(Base):
    __tablename__ = 'players'

    id = Column(UUID(as_uuid=True), primary_key=True, nullable=False)
    name = Column(String(255), unique=True, nullable=False)
    user_id = Column(UUID(as_uuid=True), nullable=False)


class TeamModel(Base):
    __tablename__ = 'teams'

    id = Column(UUID(as_uuid=True), primary_key=True, nullable=False)
    creator_id = Column(UUID(as_uuid=True), nullable=False)
    name = Column(String(255), unique=True, nullable=False)