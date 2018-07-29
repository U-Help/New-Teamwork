import json
from app.item import item
from flask import request
from start import db, token
from app.model import *


@item.route('/hall', methods=['POST'])
def hall():
    user_id = json.loads(request.json)["id"]
    res = {}
    if token[user_id] == json.loads(request.json)["token"]:
        offset = json.loads(request.json)["offset"]
        result = Items.query.filter_by(is_available=1).limit(offset, 10)
        a = list
        for elem in result:
            a.append(elem.dump_to_dict())
        res['state'] = 'success'
        res['data'] = a
        return json.dumps(res)
    res['state'] = 'failure'
    return json.dumps(res)


@item.route('/propose', methods=['POST'])
def propose():
    req = json.loads(request.json)
    user_id = req["id"]
    if token[user_id] == req["token"]:
        rtime = req['rece_time']
        splace = req['srcplace']
        dplace = req['dstplace']
        size = req['size']
        price = req['price']
        msg = req['msg']
        is_available = true
        new_item = Items(rece_time=rtime, srcplace=splace,
                         dstplace=dplace, size=size, price=price, msg=msg,
                         is_available=is_available)
        db.session.add(new_item)
        db.session.commit()

        item_id = db.session.execute(SELECT LAST_INSERT_ID())
        proposer_id = user_id
        new_pub = Pubs(proposer_id=proposer_id, item_id=item_id)
        db.session.add(new_pub)
        db.session.commit()
        message = {"item_id": item_id, "state": "success"}
        return json.dumps(message)
    else:
        message = {"state": "failure"}
        return json.dumps(message)


@item.route('/accept', methods=['POST'])
def accept():
    req = json.loads(request.json)
    user_id = req["id"]
    if token[user_id] == req["token"]:
    	item_id = req['item_id']
    	Items.query.filter_by(item_id=item_id).update(is_available=false)
    	Items.query.filter_by(item_id=item_id).update(accepter=user_id)
    	return json.dumps({'state':'success'})
    return json.dumps({'state':'failure'})


