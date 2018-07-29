from start import db
from sqlalchemy.sql import func


class Users(db.Model):
    __tablename__ = 'user'#对应mysql数据库表
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(64), unique=True, index=True)
    password = db.Column(db.String(64), index=True)
    email = db.Column(db.String(64), unique=True, index=True)
    phone = db.Column(db.String(64), unique=True, index=True)
    realname = db.Column(db.String(64), index=True)

    def __init__(self, username, password, email, phone, realname):
        self.username = username
        self.password = password
        self.email = email
        self.phone = phone
        self.realname = realname
    
    def get_id(self):
        return unicode(self.id)


class Items(db.Model):
    __tablename__ = 'item'  # 对应mysql数据库表
    item_id = db.Column(db.BigInteger, primary_key=True)
    prop_time = db.Column(db.TIMESTAMP, server_default=func.now())
    rece_time = db.Column(db.DATETIME, index=True)
    srcplace = db.Column(db.String(128), index=True)
    dstplace = db.Column(db.String(128), index=True)
    size = db.Column(db.Integer, index=True)
    price = db.Column(db.Integer, index=True)
    msg = db.Column(db.String(1000))
    is_available = db.Column(db.Boolean, index=True)

    def dump_to_dict(self):
        return{
            "item_id": self.item_id,
            "prop_time": self.prop_time,
            "rece_time": self.rece_time,
            "srcplace": self.srcplace,
            "dstplace": self.dstplace,
            "size": self.size,
            "price": self.price,
            "is_available": self.is_available
        }


class Pubs(db.Model):
    __tablename__ = 'pub'  # 对应mysql数据库表
    proposer_id = db.Column(db.Integer, index=True)
    item_id = db.Column(db.BigInteger, index=True,primary_key=True)
    accepter_id = db.Column(db.Integer, index=True)

def get_item_by_id(item_id):
    return Items.query.filter_by(item_id=item_id).first()


def get_user_by_id(user_id):
    return Users.query.filter_by(id=user_id).first()
