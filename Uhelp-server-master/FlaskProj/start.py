from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from app.user import user



app = Flask(__name__)

app.config['SECRET_KEY']='JustTryGuessingMyPasssword23333'
app.config['SQLALCHEMY_DATABASE_URI'] ='mysql://root:lhr@localhost/FlaskProj'#配置数据库
app.config['SQLALCHEMY_TRACK_MODIFICATIONS']=True
db = SQLAlchemy()
db.init_app(app)

token = {}

app.register_blueprint(user, url_prefix='/user')

if __name__ == '__main__':
    app.run(debug=True)
