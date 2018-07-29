import json
from werkzeug import security
from app.user import user
from flask import request
from start import db, token
from app.model import Users

#user = Blueprint('user', __name__)


@user.route('/logout', methods=[
'POST'])
def logout():
    token.pop(json.loads(request.json)["id"])
    return('你已退出登录')
    

@user.route('/login', methods=['POST'])
def login():
    username = json.loads(request.json)["username"]
    password = json.loads(request.json)["password"]
    u = Users.query.filter_by(name=username).first()
    if u is not None and u.password == password:
        token[u.id] = security.gen_salt(20)
        message = {"id": u.id, "token": token[u.id], "state": "success"}
        return json.dumps(message)
    else:
        message = {"state": "failure"}
        return json.dumps(message)


@user.route('/email', methods=['POST'])
def check_email():
    email = json.loads(request.json)["email"]
    u = Users.query.filter_by(email=email).first()
    if u is not None:
        return json.dumps({"state": "failure"})
    return json.dumps({"state": "success"})


@user.route('/username', methods=['POST'])
def check_username():
    username = json.loads(request.json)["username"]
    u = Users.query.filter_by(username=username).first()
    if u is not None:
        return json.dumps({"state": "failure"})
    return json.dumps({"state": "success"})


@user.route('/register', methods=['POST'])
def register():
    username = json.loads(request.json)["username"]
    u = Users.query.filter_by(username=username).first()
    if u is not None:
        return json.dumps({"state": "failure"})
    email = json.loads(request.json)["email"]
    u = Users.query.filter_by(email=email).first()
    if u is not None:
        return json.dumps({"state": "failure"})
    new_user = Users(username=username, password=json.loads(request.json)["password"],
              email=email, phone=json.loads(request.json)["phone"])
    db.session.add(new_user)
    db.session.commit()
    return json.dumps({"state": "success"})


@user.route('/update', methods=['POST'])
def update():
    user_id = json.loads(request.json)["id"]
    if token[user_id] == json.loads(request.json)["token"]:
        phone = json.loads(request.json)["phone"]
        realname = json.loads(request.json)["realname"]
        Users.query.filter_by(id=user_id).update({"phone": phone, "realname": realname})
        return json.dumps({"state": "success"})
    return json.dumps({"state": "failure"})
