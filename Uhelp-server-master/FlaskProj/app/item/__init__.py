from flask import Blueprint

item = Blueprint('item', __name__,)

from app.item import view
