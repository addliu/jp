# /usr/bin/python
#  coding: utf-8
from ATM_Project.MySQL.db.DBUtil import get_connection
from ATM_Project.MySQL.model.Card import Card
from ATM_Project.MySQL.model.CreditCard import CreditCard


# Add a Card
def add(card):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.INSERT, card.get_i_p())
    cnx.commit()
    cursor.close()
    cnx.close()


# Delete a message
def delete(card, id):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.DELETE, (id, ))
    cnx.commit()
    cursor.close()
    cnx.close()


# Update a message
def update(card):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.UPDATE, card.get_u_p())
    cnx.commit()
    cursor.close()
    cnx.close()

# Query all messages
def query_all(card):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.QUERY_ALL)
    c_list = list()
    if card.KIND == "Card":
        for (ID, cn, ow, pi, pn, pw, de) in cursor:
            c = Card()
            c.set_id(ID)
            c.set_cardNum(cn)
            c.set_owner(ow)
            c.set_personID(pi)
            c.set_phoneNumber(pn)
            c.set_password(pw)
            c.set_deposit(de)
            c_list.append(c)
    elif card.KIND == "CreditCard":
        for (ID, cn, ow, pi, pn, pw, de, cl) in cursor:
            c = CreditCard()
            c.set_id(ID)
            c.set_cardNum(cn)
            c.set_owner(ow)
            c.set_personID(pi)
            c.set_phoneNumber(pn)
            c.set_password(pw)
            c.set_deposit(de)
            c.set_creditLimit(cl)
            c_list.append(c)
    cursor.close()
    cnx.close()
    return c_list


# Query a message
def query(card, id):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.QUERY, (id, ))
    if card.KIND == "Card":
        for (ID, cn, ow, pi, pn, pw, de) in cursor:
            c = Card()
            c.set_id(ID)
            c.set_cardNum(cn)
            c.set_owner(ow)
            c.set_personID(pi)
            c.set_phoneNumber(pn)
            c.set_password(pw)
            c.set_deposit(de)
    elif card.KIND == "CreditCard":
        for (ID, cn, ow, pi, pn, pw, de, cl) in cursor:
            c = CreditCard()
            c.set_id(ID)
            c.set_cardNum(cn)
            c.set_owner(ow)
            c.set_personID(pi)
            c.set_phoneNumber(pn)
            c.set_password(pw)
            c.set_deposit(de)
            c.set_creditLimit(cl)
    cursor.close()
    cnx.close()
    return c
# # Search a message
# # def query(params):
