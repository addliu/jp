#  coding: utf-8
from ATM_Project.MySQL.db.DBUtil import get_connection


# Add a Card
def add(card):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.INSERT, card.get_i_p())
    cnx.commit()
    cursor.close()
    cnx.close()


# Delete a message
def delete(card, cardNum):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.DELETE, card.get_d_p())
    cnx.commit()
    cursor.close()
    cnx.close()


# # Update a message
# def update(card_num):
#
# Query all messages
def query_all(card):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.QUERY_ALL)
    for c in cursor:
        print(c)
    cursor.close()
    cnx.close()


# Query a message
def query(card, cardNum):
    cnx = get_connection()
    cursor = cnx.cursor()
    cursor.execute(card.QUERY, cardNum)
    # cursor.execute(card.QUERY)
    for c in cursor:
        print(c)
    cursor.close()
    cnx.close()
# # Search a message
# # def query(params):
